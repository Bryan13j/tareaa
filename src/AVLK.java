class AVLK {
    private NodoAVLK laRaiz;

    AVLK() {
        laRaiz = null;
    }
    private boolean masAlto;

    //insertar un nodo, con metodo recursivo
    public void Insertar(int elemento) {
        laRaiz = InsertaenAVL(laRaiz, elemento);
        masAlto=false;
    }
    private NodoAVLK InsertaenAVL(NodoAVLK a, int elemento){
        if(a == null){ masAlto = true; return new NodoAVLK(elemento,null,null); }
        else if (elemento < a.elemento){
            a.lchild= InsertaenAVL(a.lchild,elemento);
            if(masAlto)
                switch(a.balan){
                    case 1: masAlto = false;a=balanceaIzq(a); break;
                    case 0: a.balan = 1; break;
                    case -1: masAlto=false; a.balan=0; break;
                }
        }
        else { a.rchild= InsertaenAVL(a.rchild,elemento);
            if(masAlto)
                switch(a.balan){
                    case 1: masAlto = false; a.balan = 0; break;
                    case 0: a.balan = -1; break;
                    case -1: masAlto=false; a= balanceaDer(a); break;
                }
        }
        return a;
    }

    //balancear el avl si esta desbalanceado hacia la derecha
    private NodoAVLK balanceaDer(NodoAVLK a){
        if(a.rchild.balan==-1){
            a.balan=a.rchild.balan=0;
            a = roteIzq(a);
        }
        else
        {
            switch(a.rchild.lchild.balan)
            { case 1: a.balan = 0; a.rchild.balan = -1; break;
                case 0: a.balan=a.rchild.balan=0; break;
                case -1: a.balan = 1; a.rchild.balan=0; break;
            }
            a.rchild.lchild.balan = 0;
            a = roteDerIzq(a);
        }
        return a;
    }

    //balancear el avl si esta desbalanceado hacia la izquierda
    private NodoAVLK balanceaIzq(NodoAVLK a) {
        boolean masBajo = true;
        switch(a.balan){
            case 1: if(a.lchild.balan != -1) {
                a = roteDer(a);
                if(a.balan == 0){
                    a.balan = -1;
                    a.rchild.balan=1;
                    masBajo = false;
                }
                else
                    a.balan = a.rchild.balan = 0;
            }
            else {
                a = roteIzqDer(a);
                a.rchild.balan = a.balan == 1 ? (short) -1 : (short) 0;
                a.lchild.balan = a.balan == -1 ? (short) 1 : (short) 0;
                a.balan = 0;
            }
                break;
            case 0: a.balan = 1;
                masBajo = false;
                break;
            case -1: a.balan=0;
                break;
        }
        return a;
    }
    //busca si el elemento k pertenece al AVLK
    public boolean Buscar(int k){
        return Buscar(laRaiz, k);
    }
    private boolean Buscar(NodoAVLK a, int k){
        if (a == null){
            return false;
        }
        if (k == a.elemento) {
            return true;
        }
        else if (k < a.elemento){
            return Buscar(a.rchild, k);
        } else{
            return Buscar(a.lchild, k);
        }
    }

    //rotacion doble hacia la izquierda
    private NodoAVLK roteDerIzq(NodoAVLK a) {
        a.rchild = roteDer(a.rchild);
        return roteIzq(a);
    }
    //rotacion doble hacia la derecha
    private NodoAVLK roteIzqDer(NodoAVLK a) {
        a.lchild = roteIzq(a.lchild);
        return roteDer(a);
    }

    //rotacion a la izquierda
    private NodoAVLK roteIzq(NodoAVLK a){
        NodoAVLK temp = a.rchild;
        a.rchild= temp.lchild;
        temp.lchild= a;
        return temp;
    }

    //rotacion a la derecha
    private NodoAVLK roteDer(NodoAVLK a) {
        NodoAVLK temp = a.lchild;
        a.lchild= temp.rchild;
        temp.rchild= a;
        return temp;
    }




}