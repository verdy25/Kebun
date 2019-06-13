/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.MainController;
import model.UserModel;
import view.Daftar;
import view.Login;
import view.Main;

/**
 *
 * @author verdy
 */
public class Kebun {

    public static void main(String[] args) {
        Login login = new Login();
        Daftar daftar = new Daftar();
        Main main = new Main(login, daftar);
        UserModel model = new UserModel();
        MainController m1 = new MainController(daftar, model,main);
        MainController m2 = new MainController(login, model,main);        
    }

}
