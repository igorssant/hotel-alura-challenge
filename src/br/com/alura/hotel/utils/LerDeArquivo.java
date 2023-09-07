package br.com.alura.hotel.utils;

import javax.swing.*;
import java.io.*;

public class LerDeArquivo {
    /**
     * @return conteudo lido do arquivo Integer || null em caso de erro
     */
    public static Integer leituraDeArquivo() {
        final String caminhoParaArquivo = "src/br/com/alura/hotel/numeroDeIdentificacaoDaReserva.txt";
        File arquivo = new File(caminhoParaArquivo);

        try(FileReader leitura = new FileReader(arquivo)) {
            return leitura.read();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível achar o arquivo no caminho passado.");
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Não foi possível ler o conteúdo do arquivo.\nPor favor coloque as permissões corretas, ou o caminho correto.");
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a leitura do arquivo.\nErro de conversão de tipos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro fatal.");
        }

        return null;
    }

    /**
     * @param caminhoParaArquivo String
     * @return conteudo lido do arquivo Integer || null em caso de erro
     */
    public static Integer leituraDeArquivo(final String caminhoParaArquivo) {
        File arquivo = new File(caminhoParaArquivo);

        try(FileReader leitura = new FileReader(arquivo)) {
            return leitura.read();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível achar o arquivo no caminho passado.");
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Não foi possível ler o conteúdo do arquivo.\nPor favor coloque as permissões corretas, ou o caminho correto.");
        } catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Ocorreu um erro durante a leitura do arquivo.\nErro de conversão de tipos.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro fatal.");
        }

        return null;
    }
}
