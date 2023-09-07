package br.com.alura.hotel.controller;

import br.com.alura.hotel.model.Reserva;
import java.sql.Date;
import java.util.LinkedList;

public class BuscaReserva {
    /**
     * @param valorDeBusca Date
     * @return LinkedList<Reserva>
     */
    private static LinkedList<Reserva> buscaReserva(Date valorDeBusca) {
        ReservaController reservaController = new ReservaController();

        return reservaController.buscar(valorDeBusca);
    }

    /**
     * @param valorDeBusca Double
     * @return LinkedList<Reserva>
     */
    private static LinkedList<Reserva> buscaReserva(Double valorDeBusca) {
        ReservaController reservaController = new ReservaController();

        return reservaController.buscar(valorDeBusca);
    }

    /**
     * @param valorDeBusca Integer
     * @return LinkedList<Reserva>
     */
    private static LinkedList<Reserva> buscaReserva(Integer valorDeBusca) {
        ReservaController reservaController = new ReservaController();

        return reservaController.buscar(valorDeBusca);
    }

    /**
     * @param valorDeBusca String
     * @return LinkedList<Reserva>
     */
    public static LinkedList<Reserva> buscar(String valorDeBusca) {
        try {
            return buscaReserva(Double.parseDouble(valorDeBusca));
        } catch(NumberFormatException e) {}

        try {
            return buscaReserva(Integer.parseInt(valorDeBusca));
        } catch(NumberFormatException e) {}

        try {
            return buscaReserva(Date.valueOf(valorDeBusca));
        } catch(RuntimeException e) {
            throw new RuntimeException();
        }
    }
}
