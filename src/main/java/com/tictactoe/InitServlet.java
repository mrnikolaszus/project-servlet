package com.tictactoe;



import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.taglibs.standard.extra.spath.Path;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@Log4j2
@WebServlet(name = "InitServlet", value = "/start")
public class InitServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession(true);

        var field = new Field();
        session.setAttribute("winner", Sign.EMPTY);
        var data = field.getFieldData();

        session.setAttribute("field", field);
        session.setAttribute("data", data);
        log.info("Game initiated");
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);


    }
}
