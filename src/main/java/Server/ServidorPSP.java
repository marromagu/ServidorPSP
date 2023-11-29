/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Server;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DAM_M
 */
public class ServidorPSP {

    /**
     * @param args the command line arguments
     */
    static final int Puerto = 2000;

    public ServidorPSP() {
        try {
            ServerSocket skServidor = new ServerSocket(Puerto);
            System.out.println("Escuchando el puerto " + Puerto);
            for (int nCli = 0; nCli < 10; nCli++) {
                Socket sCliente = skServidor.accept();
                OutputStream aux = sCliente.getOutputStream();
                DataOutputStream flujo_salida = new DataOutputStream(aux);
                flujo_salida.writeUTF("Hola Cliente " + nCli);
                sCliente.close();
            }
            System.out.println("Fin");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new ServidorPSP();
    }

}
