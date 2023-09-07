package br.com.alura.hotel.utils;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class EscreverEmArquivo {
    /**
     * @param idReserva Integer
     */
    public static void escreverEmArquivo(Integer idReserva) {
        final String caminhoParaArquivo = "src/br/com/alura/hotel/numeroDeIdentificacaoDaReserva.txt";
        File arquivo = new File(caminhoParaArquivo);

        try(FileWriter escrita = new FileWriter(arquivo)) {
            escrita.write(idReserva);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível achar o arquivo no caminho passado.");
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Não foi possível escrever o conteúdo no arquivo.\nPor favor coloque as permissões corretas, ou o caminho correto.");
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a escrita no arquivo.\nErro de conversão de tipos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro fatal.");
        }
    }

    /**
     * @param caminhoParaArquivo String
     * @param idReserva Integer
     */
    public static void escreverEmArquivo(final String caminhoParaArquivo, Integer idReserva) {
        File arquivo = new File(caminhoParaArquivo);

        try(FileWriter escrita = new FileWriter(arquivo)) {
            escrita.write(idReserva);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível achar o arquivo no caminho passado.");
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Não foi possível escrever o conteúdo no arquivo.\nPor favor coloque as permissões corretas, ou o caminho correto.");
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a escrita no arquivo.\nErro de conversão de tipos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro fatal.");
        }
    }
}
