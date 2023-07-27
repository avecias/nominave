/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.avecias.nominave.controller.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.avecias.nominave.model.dto.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author aveci
 */
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Result getOneById(@PathVariable int id, HttpServletRequest request, HttpServletResponse response) {
        Result result = new Result(200, "Variable recibida " + id);
        return result;
    }
}
