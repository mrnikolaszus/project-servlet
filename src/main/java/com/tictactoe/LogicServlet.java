package com.tictactoe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "LogicServlet", value = "/logic")
public class LogicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        var session = req.getSession();
        var field = extractField(session);
        var index = getSelectedIndex(req);
        var sign = field.getField().get(index);

        if(Sign.EMPTY != sign){
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        field.getField().put(index, Sign.CROSS);
        if(checkWin(resp, session, field)){
            return;
        }

        var emptyFieldIndex = field.getEmptyFieldIndex();
        if(emptyFieldIndex>=0){
            field.getField().put(emptyFieldIndex, Sign.NOUGHT);
            if(checkWin(resp, session, field)){
                return;
            }


        }
        else {
            session.setAttribute("draw", true);
            var fieldData = field.getFieldData();
            session.setAttribute("data", fieldData);
            resp.sendRedirect("/index.jsp");
            return;
        }


        var data = field.getFieldData();
        session.setAttribute("data", data);
        session.setAttribute("field", field);



        resp.sendRedirect("/index.jsp");
    }

    private Field extractField(HttpSession session) {
        var field = session.getAttribute("field");
        if(field == null){ //TODO ???
            getServletContext().getRequestDispatcher("/start.jsp");
        }
        if(Field.class != field.getClass()){
            session.invalidate();
            throw new RuntimeException("Session is broken, try one more time");
        }
        return (Field) field;
    }

    private int getSelectedIndex(HttpServletRequest req) {
        var click = req.getParameter("click");
        var isNumeric = click.chars().allMatch(Character::isDigit);
        return isNumeric ? Integer.parseInt(click) : 0;
    }

    private boolean checkWin(HttpServletResponse res, HttpSession session, Field field) throws IOException {
        var winner = field.checkWin();
        if(Sign.CROSS == winner || Sign.NOUGHT == winner){

            session.setAttribute("winner", winner);

            var data = field.getFieldData();

            session.setAttribute("data", data);

            res.sendRedirect("/index.jsp");
            return true;

        }
        return false;
    }
}
