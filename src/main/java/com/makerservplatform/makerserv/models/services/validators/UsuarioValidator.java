package com.makerservplatform.makerserv.models.services.validators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsuarioValidator {
    public static boolean validaSenha(String senha){
        boolean senhaEhValida = false;
        // Padrões de senha
        Pattern numeros = Pattern.compile("[0-9]");
        Pattern letraMaiuscula = Pattern.compile("[A-Z]");
        Pattern caracterEspecial = Pattern.compile("['#@!\"$%¨&*()_+=`^\\[{}\\];:,.|´?/~-]");

        // Conferindo se possui os padrões
        Matcher contemNumeros = numeros.matcher(senha);
        Matcher contemLetraMaiuscula = letraMaiuscula.matcher(senha);
        Matcher contemCaracterEspecial = caracterEspecial.matcher(senha);

        if(senha.length() >= 8){
            senhaEhValida = contemNumeros.find() && contemLetraMaiuscula.find() && contemCaracterEspecial.find();
        }
        return senhaEhValida;
    }
    private static ArrayList<Integer> calculaDigitosVerificadores(String cpf){
        // Transforma o cpf em um ArrayList de strings
        ArrayList<String> cpfSemVerificadores = new ArrayList<String>(Arrays.asList(cpf.split("")));

        // Remove os dígitos verificadores (Pós '-')
        cpfSemVerificadores.remove(10);
        cpfSemVerificadores.remove(9);

        int resto;
        ArrayList<Integer> digitosCalculados = new ArrayList<Integer>();
        // Repete o cálculo para cada dígito verificador
        for(int c = 0; c < 2; c++) {
            // Controla o valor inicial da variável "peso"
            int aux = (c == 1) ? 0 : 1;

            // Faz o cálculo com os 9 dígitos do cpf
            int soma = 0;
            for (int i = 0; i < cpfSemVerificadores.size(); i++) {
                int peso = i + aux;
                soma += peso * Integer.parseInt(cpfSemVerificadores.get(i));
            }
            resto = soma % 11;
            // Se o resto for 10, substitui o verificador por 0.
            int verificador = (resto == 10) ? 0 : resto;
            cpfSemVerificadores.add(Integer.toString(verificador));

            digitosCalculados.add(verificador);
        }
        return digitosCalculados;
    }

    private static boolean verificaNumerosIguaisCpf(String cpf){
        char[] listaDigitosCpf = cpf.toCharArray();
        boolean saoNumerosRepetidos;

        int aux = 0;
        for(int i = 0; i < listaDigitosCpf.length; i++){
            if (listaDigitosCpf[i] == listaDigitosCpf[0]){
                aux++;
            }
        }
        saoNumerosRepetidos = aux == listaDigitosCpf.length;
        return saoNumerosRepetidos;
    }

    public static boolean validaCpf(String cpf){
        String cpfFormatado = cpf.replace(".", "").replace("-", "");
        boolean cpfValido = true;

        if(cpfFormatado.length() == 11){
            char[] digitosVerificadores = {cpfFormatado.toCharArray()[9], cpfFormatado.toCharArray()[10]};
            ArrayList<Integer> digitosCalculados = calculaDigitosVerificadores(cpfFormatado);
            for(int i = 0; i < 2; i++){
                if(Character.getNumericValue(digitosVerificadores[i]) != digitosCalculados.get(i)
                        || verificaNumerosIguaisCpf(cpfFormatado)){
                    cpfValido = false;
                    break;
                }
            }
        } else {
            cpfValido = false;
        }

        return cpfValido;
    }
}
