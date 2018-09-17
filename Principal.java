package Alcode.Juego;

import java.util.Random;
import java.util.Scanner;

public class Principal {

    public static void main(String[] Alcode) {
        Random rand = new Random(System.nanoTime());
        int ataque_1, ataque_2, ataque_3, opJugador;
        String ganador = "";
        String[] proceso_l1, proceso_l2, proceso_l3;
        proceso_l1 = new String[100];
        proceso_l2 = new String[100];
        proceso_l3 = new String[100];
        llenadoVidaGrafico(proceso_l1, proceso_l2, proceso_l3);
        Luchador l1 = new Luchador();
        Luchador l2 = new Luchador();
        Luchador l3 = new Luchador();
        boolean vida = true;
        ataque_1 = rand.nextInt(20);
        ataque_2 = rand.nextInt(20);
        ataque_3 = rand.nextInt(20);
        opJugador = rand.nextInt(2) + 1;

        Jugadores(l1, ataque_1, l2, ataque_2, l3, ataque_3);

        Scanner entrada = new Scanner(System.in);

        byte eleccion;

        eleccion = Menu(entrada);
        menuSelectorJugadoresPc(eleccion, l1, opJugador, vida, l2, ganador, proceso_l1, l3);

    }
//------------------------METODOS-----------------------------------------------//
    private static void menuSelectorJugadoresPc(byte eleccion, Luchador l1, int opJugador, boolean vida, Luchador l2, String ganador, String[] proceso_l1, Luchador l3) {
        switch (eleccion) {
            case 1:
                System.out.println("\tElegiste a " + l1.getNombre() + "\n");
                System.out.print("\tVas a jugar contra");

                switch (opJugador) {
                    case 1:
                        vidaZubZeroVsScorpion(vida, l1, l2, ganador, proceso_l1);
                        break;
                    case 2:

                        vidaZubZeroVsKunglao(vida, l1, l3, ganador, proceso_l1);
                        break;
                    default:
                        System.out.println("Entrada incorrecta");

                }
                break;
            case 2:
                System.out.println("\tElegiste a " + l2.getNombre() + "\n");
                System.out.print("\tVas a jugar contra" + "\n");

                switch (opJugador) {
                    case 1:
                        vidaScorpionVsZubZero(vida, l2, l1, ganador, proceso_l1);

                        break;
                    case 2:

                        vidaScorpionVsKunglao(vida, l2, l3, ganador, proceso_l1);
                        break;
                    default:
                        System.out.println("Entrada incorrecta");

                }
                break;
            case 3:
                System.out.println("\tElegiste a " + l3.getNombre() + "\n");
                System.out.print("\tVas a jugar contra" + "\n");

                switch (opJugador) {
                    case 1:
                        vidaKunglaoVsZubZero(vida, l3, l1, ganador, proceso_l1);
                        break;
                    case 2:

                        vidaKunglaoVsScorpion(vida, l3, l2, ganador, proceso_l1);
                        break;
                    default:
                        System.out.println("Entrada incorrecta");

                }
                break;
            default:
                System.out.println("Entrada incorrecta");

        }
    }


    private static void muestraVidaGrafico_L3(String[] proceso_l1, Luchador l3) {
        System.out.print("");
        for (int i = 0; i <= proceso_l1.length - (100 - (l3.getVida())); i++) {

            System.out.print(proceso_l1[i]);
        }
        System.out.println(" ");

    }

    private static void muestraVidaGrafico_L2(String[] proceso_l1, Luchador l2) {
        System.out.print("");
        for (int i = 0; i <= proceso_l1.length - (100 - (l2.getVida())); i++) {

            System.out.print(proceso_l1[i]);
        }
        System.out.println(" ");

    }

    private static void muestraVidaGrafico_L1(String[] proceso_l1, Luchador l1) {
        System.out.print("");
        for (int i = 0; i <= proceso_l1.length - (100 - (l1.getVida())); i++) {

            System.out.print(proceso_l1[i]);
        }
        System.out.println(" ");

    }

    private static void llenadoVidaGrafico(String[] proceso_l1, String[] proceso_l2, String[] proceso_l3) {
        for (int i = 0; i < proceso_l1.length; i++) {
            proceso_l1[i] = "=";

        }
    }

    private static void vidaKunglaoVsScorpion(boolean vida, Luchador l3, Luchador l2, String ganador, String[] proceso_l1) {
        System.out.println("\tScopion\n");
        while (vida) {
            l3.setVida(l3.getVida() - l2.getFuerza());
            l2.setVida(l2.getVida() - l3.getFuerza());
            if ((l3.getVida() <= 0) || (l2.getVida() <= 0)) {
                vida = false;
            }
            System.out.print("\tVida de " + l3.getNombre() + " ");
            muestraVidaGrafico_L1(proceso_l1, l3);
            System.out.println("\tLa vida de " + l3.getNombre() + " es de " + l3.getVida() + "\n");
            System.out.print("\tVida de " + l2.getNombre() + " ");
            muestraVidaGrafico_L1(proceso_l1, l2);
            System.out.println("\tLa vida de " + l2.getNombre() + " es de " + l2.getVida() + "\n");
            ganador = l3.getVida() > 0 ? "\tEL ganador es Kunglao" : "El ganador es Scorpion";

        }
        System.out.println(ganador);
    }

    private static void vidaKunglaoVsZubZero(boolean vida, Luchador l3, Luchador l1, String ganador, String[] proceso_l1) {
        System.out.println("\tZubZero\n");
        while (vida) {
            l3.setVida(l3.getVida() - l1.getFuerza());
            l1.setVida(l1.getVida() - l3.getFuerza());
            if ((l3.getVida() <= 0) || (l1.getVida() <= 0)) {
                vida = false;
            }
            System.out.print("\tVida de " + l3.getNombre() + " ");
            muestraVidaGrafico_L1(proceso_l1, l3);
            System.out.println("\tLa vida de " + l3.getNombre() + " es de " + l3.getVida() + "\n");
            System.out.print("\tVida de " + l1.getNombre() + " ");
            muestraVidaGrafico_L1(proceso_l1, l1);
            System.out.println("\tLa vida de " + l1.getNombre() + " es de " + l1.getVida() + "\n");
            ganador = l3.getVida() > 0 ? "\tEL ganador es Kunglao" : "El ganador es ZubZero";

        }
        System.out.println(ganador);
    }

    private static void vidaScorpionVsKunglao(boolean vida, Luchador l2, Luchador l3, String ganador, String[] proceso_l1) {
        System.out.println("\tKunglao\n");
        while (vida) {
            l2.setVida(l2.getVida() - l3.getFuerza());
            l3.setVida(l3.getVida() - l2.getFuerza());
            if ((l2.getVida() <= 0) || (l3.getVida() <= 0)) {
                vida = false;
            }
            System.out.print("\tVida de " + l2.getNombre() + " ");
            muestraVidaGrafico_L1(proceso_l1, l2);
            System.out.println("\tLa vida de " + l2.getNombre() + " es de " + l2.getVida() + "\n");
            System.out.print("\tVida de " + l3.getNombre() + " ");
            muestraVidaGrafico_L1(proceso_l1, l3);
            System.out.println("\tLa vida de " + l3.getNombre() + " es de " + l3.getVida() + "\n");
            ganador = l2.getVida() > 0 ? "\tEL ganador es Scorpion" : "El ganador es Kunglao";

        }
        System.out.println(ganador);
    }

    private static void vidaScorpionVsZubZero(boolean vida, Luchador l2, Luchador l1, String ganador, String[] proceso_l1) {
        System.out.println("\tZubZero\n");
        while (vida) {
            l2.setVida(l2.getVida() - l1.getFuerza());
            l1.setVida(l1.getVida() - l2.getFuerza());
            if ((l2.getVida() <= 0) || (l1.getVida() <= 0)) {
                vida = false;
            }
            System.out.print("\tVida de " + l2.getNombre() + " ");
            muestraVidaGrafico_L1(proceso_l1, l2);
            System.out.println("\tLa vida de " + l2.getNombre() + " es de " + l2.getVida() + "\n");
            System.out.print("\tVida de " + l1.getNombre() + " ");
            muestraVidaGrafico_L1(proceso_l1, l1);
            System.out.println("\tLa vida de " + l1.getNombre() + " es de " + l1.getVida() + "\n");
            ganador = l2.getVida() > 0 ? "\tEL ganador es Scorpion" : "El ganador es ZubZero";

        }
        System.out.println(ganador);
    }

    private static void vidaZubZeroVsKunglao(boolean vida, Luchador l1, Luchador l3, String ganador, String[] proceso_l1) {
        System.out.println("\tKunglao\n");
        while (vida) {
            l1.setVida(l1.getVida() - l3.getFuerza());
            l3.setVida(l3.getVida() - l1.getFuerza());
            if ((l1.getVida() <= 0) || (l3.getVida() <= 0)) {
                vida = false;
            }
            System.out.print("\tVida de " + l1.getNombre() + " ");
            muestraVidaGrafico_L1(proceso_l1, l1);
            System.out.println("\tLa vida de " + l1.getNombre() + " es de " + l1.getVida() + "\n");
            System.out.print("\tVida de " + l3.getNombre() + " ");
            muestraVidaGrafico_L1(proceso_l1, l3);
            System.out.println("\tLa vida de " + l3.getNombre() + " es de " + l3.getVida() + "\n");
            ganador = l1.getVida() > 0 ? "\tEL ganador es ZubZero" : "El ganador es Kunglao";

        }
        System.out.println(ganador);
    }

    private static void vidaZubZeroVsScorpion(boolean vida, Luchador l1, Luchador l2, String ganador, String[] proceso_l1) {
        System.out.println("\tScorpion\n");
        while (vida) {
            l1.setVida(l1.getVida() - l2.getFuerza());
            l2.setVida(l2.getVida() - l1.getFuerza());
            if ((l1.getVida() <= 0) || (l2.getVida() <= 0)) {
                vida = false;
            }
            System.out.print("\tVida de " + l1.getNombre() + " ");
            muestraVidaGrafico_L1(proceso_l1, l1);
            System.out.println("\tLa vida de " + l1.getNombre() + " es de " + l1.getVida() + "\n");
            System.out.print("\tVida de " + l2.getNombre() + " ");
            muestraVidaGrafico_L1(proceso_l1, l2);
            System.out.println("\tLa vida de " + l2.getNombre() + " es de " + l2.getVida() + "\n");
            ganador = l1.getVida() > 0 ? "\tEL ganador es ZubZero" : "El ganador es Scopion";

        }
        System.out.println(ganador);
    }

    private static void Jugadores(Luchador l1, int ataque_1, Luchador l2, int ataque_2, Luchador l3, int ataque_3) {
        l1.setNombre("Zub Zero");
        l1.setVida(100);
        l1.setFuerza(ataque_1);

        l2.setNombre("Scorpion");
        l2.setVida(100);
        l2.setFuerza(ataque_2);

        l3.setNombre("Kunglao");
        l3.setVida(100);
        l3.setFuerza(ataque_3);
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
