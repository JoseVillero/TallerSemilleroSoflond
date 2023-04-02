package controllers;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.entities.User;
import models.services.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class UserController extends HttpServlet {

    private UserService userService = new UserService();
    private ObjectMapper mapper = new ObjectMapper();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = req.getPathInfo();

        if(path == null){
            List<?> users = userService.obtenerTodo();
            resp.setContentType("application/json");
            resp.getWriter().println(users);
        } else{
            switch (path) {
                case "/buscar":
                    String identificador = req.getParameter("identificador");
                    try {
                        User user = userService.buscar(identificador);
                        String json = mapper.writeValueAsString(user);
                        resp.setContentType("application/json");
                        resp.getWriter().println(json);
                    } catch (Exception e) {
                        resp.setStatus(404);
                        Map<String, String> error = new HashMap<>();
                        error.put("error", e.getMessage());
                        String json = mapper.writeValueAsString(error);
                        resp.setContentType("application/json");
                        resp.getWriter().println(json);
                    }
                    break;
                default:
                    resp.setStatus(404);
                    Map<String, String> error = new HashMap<>();
                    error.put("error", "No se encontro el recurso");
                    String json = mapper.writeValueAsString(error);
                    resp.setContentType("application/json");
                    resp.getWriter().println(json);
                    break;
            }
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

        String content = request.getContentType();

        if (content != null && content.equals("application/json")) {
            Map<String, Object> userMap = mapper.readValue(request.getInputStream(), HashMap.class);
            try {
                userService.guardar(userMap);
                response.setStatus(HttpServletResponse.SC_CREATED);
                Map<String, String> respuesta = new HashMap<>();
                respuesta.put("mensaje", "Usuario guardado con exito");
                String json = mapper.writeValueAsString(respuesta);
                response.setContentType("application/json");
                response.getWriter().println(json);

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                Map<String, String> error = new HashMap<>();
                error.put("error", e.getMessage());
                String json = mapper.writeValueAsString(error);
                response.setContentType("application/json");
                response.getWriter().println(json);
            }

        } else {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            Map<String, String> error = new HashMap<>();
            error.put("error", "El contenido debe ser JSON");
            String json = mapper.writeValueAsString(error);
            response.setContentType("application/json");
            response.getWriter().println(json);
        }
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String content = request.getContentType();
        if(content == "application/json") {
            Map <String, Object> userMap = mapper.readValue(request.getInputStream(), HashMap.class);

            try {
                userService.actualizar(userMap);
                response.setStatus(HttpServletResponse.SC_OK);
                Map<String, String> respuesta = new HashMap<>();
                respuesta.put("mensaje", "El usuario es actualizado con exito");
                String json = mapper.writeValueAsString(respuesta);
                response.setContentType("application/json");
                response.getWriter().println(json);

            } catch (Exception e) {
                response.setStatus(HttpServletResponse.SC_CONFLICT);
                Map<String, String> error = new HashMap<>();
                error.put("error", e.getMessage());
                String json = mapper.writeValueAsString(error);
                response.setContentType("application/json");
                response.getWriter().println(json);
            }

        } else {
            response.setStatus(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
            Map<String, String> error = new HashMap<>();
            error.put("error", "El contenido debe ser JSON");
            String json = mapper.writeValueAsString(error);
            response.setContentType("application/json");
            response.getWriter().println(json);
        }
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

        String identificador = request.getParameter("identificador");
        try {
            userService.eliminar(identificador);

            response.setStatus(HttpServletResponse.SC_OK);
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("mensaje", "Usuario eliminado con exito");
            String json = mapper.writeValueAsString(respuesta);
            response.setContentType("application/json");
            response.getWriter().println(json);
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            Map<String, String> error = new HashMap<>();
            error.put("error", e.getMessage());
            String json = mapper.writeValueAsString(error);
            response.setContentType("application/json");
            response.getWriter().println(json);
        }
    }


}
