<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<%@ include file="header.jsp" %>

<%
    User user = (User) request.getSession().getAttribute("selectedUser");
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
                    <br/>

                    <% for (int i = 0; i < accounts.size(); i++) {%>
                        <%String accountNumber = accounts.get(i).getAccountNumber();%>
                        <input type="radio" name="check" value="<%=accountNumber%>" onclick="location.href='../account/<%=accountNumber%>'"/><%=accountNumber%>
                        <br/>
                        <br/>
                    <%}%>
                </center>
            </td>
        </tr>
    </table>
</center>
