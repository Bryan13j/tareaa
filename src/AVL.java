class AVL {
    private NodoAVL laRaiz;

    AVL() {
        laRaiz = null;
    }
    private boolean masAlto;

    //insertar un nodo, con metodo recursivo
    public void Insertar(int elemento) {
        laRaiz = InsertaenAVL(laRaiz, elemento);
        masAlto=false;
    }
    private NodoAVL InsertaenAVL(NodoAVL a, int elemento){
        if(a == null){ masAlto = true; return new NodoAVL(elemento,null,null); }
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
    private NodoAVL balanceaDer(NodoAVL a){
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

    //balancear el avl si esta desballanceado hacia la izquierda
    private NodoAVL balanceaIzq(NodoAVL a) {
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

    //rotacion doble hacia la izquierda
    private NodoAVL roteDerIzq(NodoAVL a) {
        a.rchild = roteDer(a.rchild);
        return roteIzq(a);
    }
    //rotacion doble hacia la derecha
    private NodoAVL roteIzqDer(NodoAVL a) {
        a.lchild = roteIzq(a.lchild);
        return roteDer(a);
    }

    //rotacion a la izquierda
    private NodoAVL roteIzq(NodoAVL a){
        NodoAVL temp = a.rchild;
        a.rchild= temp.lchild;
        temp.lchild= a;
        return temp;
    }

    //rotacion a la derecha
    private NodoAVL roteDer(NodoAVL a) {
        NodoAVL temp = a.lchild;
        a.lchild= temp.rchild;
        temp.rchild= a;
        return temp;
    }




}