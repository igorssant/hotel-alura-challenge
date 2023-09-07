package br.com.alura.hotel.controller;

import br.com.alura.hotel.model.Hospede;

import java.sql.Date;
import java.util.LinkedList;

public class BuscarHospede {
    /**
     * @param valorDeBusca Integer
     * @return LinkedList<Hospede>
     */
    private static LinkedList<Hospede> buscaHospede(Integer valorDeBusca) {
        HospedeController hospedeController = new HospedeController();

        return hospedeController.buscar(valorDeBusca);
    }

    /**
     * @param valorDeBusca java.sql.Date
     * @return LinkedList<Hospede>
     */
    private static LinkedList<Hospede> buscaHospede(Date valorDeBusca) {
        HospedeController hospedeController = new HospedeController();

        return hospedeController.buscar(valorDeBusca);
    }

    /**
     * @param valorDeBusca String
     * @return LinkedList<Hospede>
     */
    private static LinkedList<Hospede> buscaHospede(String valorDeBusca) {
        HospedeController hospedeController = new HospedeController();

        return hospedeController.buscar(valorDeBusca);
    }

    /**
     * @param valorDeBusca String
     * @return LinkedList<Hospede>
     */
    public static LinkedList<Hospede> buscar(String valorDeBusca) {
        try {
            return buscaHospede(Integer.parseInt(valorDeBusca));
        } catch(NumberFormatException e) {}

        try {
            return buscaHospede(Date.valueOf(valorDeBusca));
        } catch(Exception e) {}

        return buscaHospede(valorDeBusca);
    }
}
