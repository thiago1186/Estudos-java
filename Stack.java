class Stack{
  private int[] itens = new int[100];
  private int length = 0;

  private void setLength(){
    int[] itens = new int[this.getLength()*2];

    for(int x = 0; x < this.getLength(); x++){
      itens[x] = this.itens[x];
    }

    this.itens = itens;
  }

  public void push(int element){
    if(this.getLength() == this.itens.length){
      this.setLength();
    }
    
    this.itens[this.length++] = element;
  }

  public int peek(){
    if(this.isEmpty()){
      throw new IllegalArgumentException("Pilha vazia.");
    }

    return this.itens[this.length-1];
  }

  public int pop(){
    if(this.isEmpty()){
      throw new IllegalArgumentException("Pilha vazia.");
    }

    return this.itens[--this.length];
  }

  private Boolean isEmpty(){
    return this.getLength() == 0;
  }

  public int getLength(){
    return this.length;
  }

  public String toString(){
    StringBuilder str = new StringBuilder();
    str.append("[");
    
    for(int x = 0; x < this.length; x++){
      str.append(this.itens[x]);

      if(x != this.length-1){
        str.append(",");
      }
    }

    str.append("]");
    return str.toString();
  }
}
