/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package evaluacionparcialuno;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RegistroAcceso {
    private Date horaEntrada;
    private Date horaSalida;
    private static final SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    public RegistroAcceso() {
        // Inicializa las fechas en null, ya que se registrarán cuando sea necesario
        this.horaEntrada = null;
        this.horaSalida = null;
    }

    public Date getHoraEntrada() {
        return this.horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return this.horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void registrarEntrada() {
        this.horaEntrada = new Date(); // Registra la hora actual como la hora de entrada
    }

    public void registrarSalida() {
        this.horaSalida = new Date(); // Registra la hora actual como la hora de salida
    }

    @Override
    public String toString() {
        String entrada = (horaEntrada != null) ? format.format(horaEntrada) : "No registrado";
        String salida = (horaSalida != null) ? format.format(horaSalida) : "No registrado";
        return "RegistroAcceso{entrada=" + entrada + ", salida=" + salida + '}';
    }
}