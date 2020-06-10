<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<hr/>
<br/>
<br/>

<center>
    <table>
        <tr>
            <td style="border:1; border-style:inset; padding:40px">
                <center>
                    <h3>Connexion à votre espace personnel</h3>
                    <%
                        String profile_msg=(String)request.getAttribute("profile_msg");

                        if(profile_msg!=null){
                            out.print(profile_msg);
                        }

                        String login_msg=(String)request.getAttribute("login_msg");

                        if(login_msg!=null){
                            out.print(login_msg);
                        }
                    %>

                    <form action="rest/user" method="post" style="width: 450px;margin-left: auto;margin-right: auto">
                           <table>
                                <tr>
                                    <td>Identifiant</td>
                                    <td><input type="text" name="login" /></td>
                                </tr>
                                <tr>
                                    <td>Mot de passe</td>
                                    <td><input type="password" name="password"/></td>
                                </tr>
                           </table>
                           <br/>
                           <input type="submit" value="Connexion"/>
                    </form>
                </center>
            </td>
        </tr>
    </table>
</center>
