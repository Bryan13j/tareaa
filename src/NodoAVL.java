class NodoAVL {
    NodoAVL lchild;
    int elemento;
    short balan;
    NodoAVL rchild;

    NodoAVL(int elemento, NodoAVL lchild, NodoAVL rchild) {
        this.elemento = elemento;
        this.lchild = lchild;
        this.rchild = rchild;
        this.balan = 0;
    }
}