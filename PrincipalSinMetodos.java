package Alcode.Juego.SinGetSetrs;

import java.util.Random;
import java.util.Scanner;

public class Principal {

    public static void main(String[] Alcode) {
        Random rand = new Random(System.nanoTime());
        int ataque_1, ataque_2, ataque_3, opJugador, opJugadorBatalla;
        String ganador = "";
        String[] proceso_l1;
        proceso_l1 = new String[100];
        llenadoVidaGrafico(proceso_l1);
        LuchadorPublic l1 = new LuchadorPublic();
        LuchadorPublic l2 = new LuchadorPublic();
        LuchadorPublic l3 = new LuchadorPublic();
        boolean vida = true;
        ataque_1 = rand.nextInt(20);
        ataque_2 = rand.nextInt(20);
        ataque_3 = rand.nextInt(20);
        opJugador = rand.nextInt(2) + 1;
        opJugadorBatalla = rand.nextInt(2) + 1;

        Jugadores(l1, ataque_1, l2, ataque_2, l3, ataque_3);

        Scanner entrada = new Scanner(System.in);
        
        

        byte eleccion;

        eleccion = Menu(entrada);
        menuSelectorJugadoresPc(eleccion, l1, opJugador, vida, l2, ganador, proceso_l1, l3, opJugadorBatalla);

    }
//------------------------METODOS-----------------------------------------------//

    private static void menuSelectorJugadoresPc(byte eleccion, LuchadorPublic l1, int opJugador, boolean vida, LuchadorPublic l2, String ganador, String[] proceso_l1, LuchadorPublic l3, int opJugadorBatalla) {
        switch (eleccion) {
            case 1:
                System.out.println("\tElegiste a " + l1.Nombre + "\n");
                System.out.print("\tVas a jugar contra");

                switch (opJugador) {
                    case 1:
                        vidaZubZeroVsScorpion(vida, l1, l2, ganador, proceso_l1, opJugadorBatalla);
                        break;
                    case 2:

                        vidaZubZeroVsKunglao(vida, l1, l3, ganador, proceso_l1, opJugadorBatalla);
                        break;
                    default:
                        System.out.println("Entrada incorrecta");

                }
                break;
            case 2:
                System.out.println("\tElegiste a " + l2.Nombre + "\n");
                System.out.print("\tVas a jugar contra" + "\n");

                switch (opJugador) {
                    case 1:
                        vidaScorpionVsZubZero(vida, l2, l1, ganador, proceso_l1, opJugadorBatalla);

                        break;
                    case 2:

                        vidaScorpionVsKunglao(vida, l2, l3, ganador, proceso_l1, opJugadorBatalla);
                        break;
                    default:
                        System.out.println("Entrada incorrecta");

                }
                break;
            case 3:
                System.out.println("\tElegiste a " + l3.Nombre + "\n");
                System.out.print("\tVas a jugar contra" + "\n");

                switch (opJugador) {
                    case 1:
                        vidaKunglaoVsZubZero(vida, l3, l1, ganador, proceso_l1, opJugadorBatalla);
                        break;
                    case 2:

                        vidaKunglaoVsScorpion(vida, l3, l2, ganador, proceso_l1, opJugadorBatalla);
                        break;
                    default:
                        System.out.println("Entrada incorrecta");

                }
                break;
            default:
                System.out.println("Entrada incorrecta");

        }
    }

    private static void muestraVidaGrafico_L1(String[] proceso_l1, LuchadorPublic l1) {
        System.out.print("");
        for (int i = 0; i <= proceso_l1.length - (100 - (l1.Vida)); i++) {

            System.out.print(proceso_l1[i]);
        }
        System.out.println(" ");

    }

    private static void llenadoVidaGrafico(String[] proceso_l1) {
        for (int i = 0; i < proceso_l1.length; i++) {
            proceso_l1[i] = "=";

        }
    }

    private static void vidaKunglaoVsScorpion(boolean vida, LuchadorPublic l3, LuchadorPublic l2, String ganador, String[] proceso_l1, int opJugadorBatalla) {
        System.out.println("\tScopion\n");
        while (vida) {
            l3.Vida=l3.Vida - l2.Fuerza;
            l2.Vida=l2.Vida - l3.Fuerza;
            if ((l3.Vida <= 0) || (l2.Vida <= 0)) {
                vida = false;
            }
            switch (opJugadorBatalla) {
                case 1:
                    System.out.print("\tVida de " + l3.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l3);
                    System.out.println("\tLa vida de " + l3.Nombre + " es de " + l3.Vida + "\n");
                    System.out.print("\tVida de " + l2.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l2);
                    System.out.println("\tLa vida de " + l2.Nombre + " es de " + l2.Vida + "\n");
                    break;
                case 2:
                    System.out.print("\tVida de " + l2.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l2);
                    System.out.println("\tLa vida de " + l2.Nombre + " es de " + l2.Vida + "\n");
                    System.out.print("\tVida de " + l3.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l3);
                    System.out.println("\tLa vida de " + l3.Nombre + " es de " + l3.Vida + "\n");
                    break;
                default:
                    System.out.println("opJugador erroneo");

            }

            ganador = l3.Vida > 0 ? "\tEL ganador es Kunglao" : "El ganador es Scorpion";

        }
        System.out.println(ganador);
    }

    private static void vidaKunglaoVsZubZero(boolean vida, LuchadorPublic l3, LuchadorPublic l1, String ganador, String[] proceso_l1, int opJugadorBatalla) {
        System.out.println("\tZubZero\n");
        while (vida) {
            l3.Vida=l3.Vida - l1.Fuerza;
            l1.Vida=l1.Vida - l3.Fuerza;
            if ((l3.Vida <= 0) || (l1.Vida <= 0)) {
                vida = false;
            }
            switch (opJugadorBatalla) {
                case 1:
                    System.out.print("\tVida de " + l1.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l1);
                    System.out.println("\tLa vida de " + l1.Nombre + " es de " + l1.Vida + "\n");

                    System.out.print("\tVida de " + l3.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l3);
                    System.out.println("\tLa vida de " + l3.Nombre + " es de " + l3.Vida + "\n");
                    break;
                case 2:
                    System.out.print("\tVida de " + l3.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l3);
                    System.out.println("\tLa vida de " + l3.Nombre + " es de " + l3.Vida + "\n");
                    System.out.print("\tVida de " + l1.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l1);
                    System.out.println("\tLa vida de " + l1.Nombre + " es de " + l1.Vida + "\n");
                    break;
                default:
                    System.out.println("opJugador erroneo");

            }

            ganador = l3.Vida > 0 ? "\tEL ganador es Kunglao" : "El ganador es ZubZero";

        }
        System.out.println(ganador);
    }

    private static void vidaScorpionVsKunglao(boolean vida, LuchadorPublic l2, LuchadorPublic l3, String ganador, String[] proceso_l1, int opJugadorBatalla) {
        System.out.println("\tKunglao\n");
        while (vida) {
            l2.Vida=l2.Vida - l3.Fuerza;
            l3.Vida=l3.Vida - l2.Fuerza;
            if ((l2.Vida <= 0) || (l3.Vida <= 0)) {
                vida = false;
            }
            switch (opJugadorBatalla) {
                case 1:
                    System.out.print("\tVida de " + l2.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l2);
                    System.out.println("\tLa vida de " + l2.Nombre + " es de " + l2.Vida + "\n");
                    System.out.print("\tVida de " + l3.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l3);
                    System.out.println("\tLa vida de " + l3.Nombre + " es de " + l3.Vida + "\n");
                    break;
                case 2:
                    System.out.print("\tVida de " + l3.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l3);
                    System.out.println("\tLa vida de " + l3.Nombre + " es de " + l3.Vida + "\n");
                    System.out.print("\tVida de " + l2.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l2);
                    System.out.println("\tLa vida de " + l2.Nombre + " es de " + l2.Vida + "\n");
                    break;
                default:
                    System.out.println("opJugador erroneo");

            }

            ganador = l2.Vida > 0 ? "\tEL ganador es Scorpion" : "El ganador es Kunglao";

        }
        System.out.println(ganador);
    }

    private static void vidaScorpionVsZubZero(boolean vida, LuchadorPublic l2, LuchadorPublic l1, String ganador, String[] proceso_l1, int opJugadorBatalla) {
        System.out.println("\tZubZero\n");
        while (vida) {
            l2.Vida=l2.Vida - l1.Fuerza;
            l1.Vida=l1.Vida - l2.Fuerza;
            if ((l2.Vida <= 0) || (l1.Vida <= 0)) {
                vida = false;
            }
            switch (opJugadorBatalla) {
                case 1:
                    System.out.print("\tVida de " + l2.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l2);
                    System.out.println("\tLa vida de " + l2.Nombre + " es de " + l2.Vida + "\n");
                    System.out.print("\tVida de " + l1.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l1);
                    System.out.println("\tLa vida de " + l1.Nombre + " es de " + l1.Vida + "\n");
                    break;
                case 2:
                    System.out.print("\tVida de " + l1.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l1);
                    System.out.println("\tLa vida de " + l1.Nombre + " es de " + l1.Vida + "\n");
                    System.out.print("\tVida de " + l2.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l2);
                    System.out.println("\tLa vida de " + l2.Nombre + " es de " + l2.Vida + "\n");
                    break;
                default:
                    System.out.println("opJugador erroneo");

            }

            ganador = l2.Vida > 0 ? "\tEL ganador es Scorpion" : "El ganador es ZubZero";

        }
        System.out.println(ganador);
    }

    private static void vidaZubZeroVsKunglao(boolean vida, LuchadorPublic l1, LuchadorPublic l3, String ganador, String[] proceso_l1, int opJugadorBatalla) {
        System.out.println("\tKunglao\n");
        while (vida) {
            l1.Vida=l1.Vida - l3.Fuerza;
            l3.Vida=l3.Vida - l1.Fuerza;
            if ((l1.Vida <= 0) || (l3.Vida <= 0)) {
                vida = false;
            }
            switch (opJugadorBatalla) {
                case 1:
                    System.out.print("\tVida de " + l1.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l1);
                    System.out.println("\tLa vida de " + l1.Nombre + " es de " + l1.Vida + "\n");
                    System.out.print("\tVida de " + l3.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l3);
                    System.out.println("\tLa vida de " + l3.Nombre + " es de " + l3.Vida + "\n");
                    break;
                case 2:
                    System.out.print("\tVida de " + l3.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l3);
                    System.out.println("\tLa vida de " + l3.Nombre + " es de " + l3.Vida + "\n");
                    System.out.print("\tVida de " + l1.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l1);
                    System.out.println("\tLa vida de " + l1.Nombre + " es de " + l1.Vida + "\n");
                    break;
                default:
                    System.out.println("opJugador erroneo");

            }

            ganador = l1.Vida > 0 ? "\tEL ganador es ZubZero" : "El ganador es Kunglao";

        }
        System.out.println(ganador);
    }

    private static void vidaZubZeroVsScorpion(boolean vida, LuchadorPublic l1, LuchadorPublic l2, String ganador, String[] proceso_l1, int opJugadorBatalla) {
        System.out.println("\tScorpion\n");
        while (vida) {
            l1.Vida=l1.Vida - l2.Fuerza;
            l2.Vida=l2.Vida - l1.Fuerza;
            if ((l1.Vida <= 0) || (l2.Vida <= 0)) {
                vida = false;
            }

            switch (opJugadorBatalla) {
                case 1:

                    System.out.print("\tVida de " + l1.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l1);
                    System.out.println("\tLa vida de " + l1.Nombre + " es de " + l1.Vida + "\n");

                    System.out.print("\tVida de " + l2.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l2);
                    System.out.println("\tLa vida de " + l2.Nombre + " es de " + l2.Vida + "\n");

                    break;
                case 2:
                    System.out.print("\tVida de " + l2.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l2);
                    System.out.println("\tLa vida de " + l2.Nombre + " es de " + l2.Vida + "\n");

                    System.out.print("\tVida de " + l1.Nombre + " ");
                    muestraVidaGrafico_L1(proceso_l1, l1);
                    System.out.println("\tLa vida de " + l1.Nombre + " es de " + l1.Vida + "\n");

                    break;
                default:
                    System.out.println("opJugador erroneo");

            }

            ganador = l1.Vida > 0 ? "\tEL ganador es ZubZero" : "El ganador es Scopion";

        }
        System.out.println(ganador);
    }

    public static void Jugadores(LuchadorPublic l1, int ataque_1, LuchadorPublic l2, int ataque_2, LuchadorPublic l3, int ataque_3) {
        l1.Nombre = "Zub Zero";
        l1.Vida=100;
        l1.Fuerza=ataque_1;

        l2.Nombre="Scorpion";
        l2.Vida=100;
        l2.Fuerza=ataque_2;

        l3.Nombre="Kunglao";
        l3.Vida=10;
        l3.Fuerza=ataque_3;
    }

    private static byte Menu(Scanner entrada) {
        byte eleccion;
        System.out.println("\t==============================================");
        System.out.println("\t================Mortal Kombat=================");
        System.out.println("\t==============================================");
        System.out.println("\t||               1.)Zub Zero                ||");
        System.out.println("\t==============================================");
        System.out.println("\t==============================================");
        System.out.println("\t||               2.)Scorpion                ||");
        System.out.println("\t==============================================");
        System.out.println("\t==============================================");
        System.out.println("\t||               3.)Kunglao                 ||");
        System.out.println("\t==============================================");
        System.out.print("\t");
        eleccion = entrada.nextByte();
        return eleccion;
    }

}
