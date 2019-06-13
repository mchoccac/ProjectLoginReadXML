
package com.app.login;

import com.app.xmlmo.ClsGeneDom;

public class AuthenticationService {


   public AuthenticationService() {
 
    }

   public boolean authenticate(String nombreArchivo, String username,String password) {
       
       ClsGeneDom probarlogin = new ClsGeneDom();
       boolean estado = probarlogin.getLoginXml(nombreArchivo, username, password);
       return estado;
    }


}
