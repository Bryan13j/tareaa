class NodoAVLK {
    NodoAVLK lchild;
    int elemento;
    short balan;
    NodoAVLK rchild;

    NodoAVLK(int elemento, NodoAVLK lchild, NodoAVLK rchild) {
        this.elemento = elemento;
        this.lchild = lchild;
        this.rchild = rchild;
        this.balan = 0;
    }
}