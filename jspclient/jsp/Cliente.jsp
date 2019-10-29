<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="testsocket.Cliente"%>
<%
	String mensaje = request.getParameter("msg");
	Cliente cli = new Cliente(); //Se crea el cliente
	out.println("Iniciando cliente\n");
	out.println(cli.startClient(mensaje)); //Se inicia el cliente
%>