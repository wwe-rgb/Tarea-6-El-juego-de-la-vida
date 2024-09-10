package ico.fes.aragon.unam.mx.clases;

public class JuegoDeLaVida {
    private Array2D rejilla;
    private int cols;
    private int rens;

    public JuegoDeLaVida(int col, int ren) {
        rejilla = new Array2D(ren, col);
        this.cols = col;
        this.rens = ren;
    }


    public void inicializarRandom() {
        for (int i = 0; i < rens; i++) {
            for (int j = 0; j < cols; j++) {

                char estado = Math.random() < 0.5 ? '〇' : '⬤';
                rejilla.setItem(i, j, estado);
            }
        }
    }

    public int contadorVecinosVivos(int ren, int col) {
        int contador = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int vecinosRen = ren + i;
                int vecinosCol = col + j;
                if (posicionValida(vecinosRen, vecinosCol) && rejilla.getItem(vecinosRen, vecinosCol) == '⬤') {
                    contador++;
                }
            }
        }
        return contador;
    }

    public boolean posicionValida(int ren, int col) {
        return ren >= 0 && ren < rens && col >= 0 && col < cols;
    }

    public void actualizacionRejilla() {
        Array2D siguienteRejilla = new Array2D(rens, cols);

        for (int i = 0; i < rens; i++) {
            for (int j = 0; j < cols; j++) {
                int vecinosVivos = contadorVecinosVivos(i, j);
                char estadoActual = rejilla.getItem(i, j);

                if (estadoActual == 'v') {  // Célula viva
                    if (vecinosVivos < 2 || vecinosVivos > 3) {
                        siguienteRejilla.setItem(i, j, '〇');
                    } else {
                        siguienteRejilla.setItem(i, j, '⬤');
                    }
                } else {  // Célula muerta
                    if (vecinosVivos == 3) {
                        siguienteRejilla.setItem(i, j, '⬤');
                    } else {
                        siguienteRejilla.setItem(i, j, '〇');
                    }
                }
            }
        }
        rejilla = siguienteRejilla; // Actualizamos el estado
    }

    // Método para imprimir la rejilla
    public void imprimirRejilla() {
        System.out.println(rejilla.toString());
    }
}
