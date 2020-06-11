<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@page import="fr.ing.interview.kata.model.bean.User"%>
<%@page import="fr.ing.interview.kata.model.bean.Account"%>
<%@page import="java.util.List"%>

<%@ include file="header.jsp" %>

<%
    User user = (User) request.getAttribute("user");
    String login = user.getLogin();
    List<Account> accounts = user.getAccountsList();
%>

<center>
    <table>
        <tr>
            <td style="border:1; border-style:inset; padding:40px">
                <center>
                    <h2>Bienvenue <%=login%></h2>
                    <h3>Merci de sélectionner un compte</h3>

                    <% for (int i = 0; i < accounts.size(); i++) {%>
                        <%String accountNumber = accounts.get(i).getAccountNumber();%>
                        <input type="radio" name="check" value="<%=accountNumber%>" onclick="location.href='../account/<%=accountNumber%>'"/><%=accounts.get(i).getAccountNumber()%>
                        <br/>
                    <%}%>
                </center>
            </td>
        </tr>
    </table>
</center>
