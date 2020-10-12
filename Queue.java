class Queue{
  private int[] itens = new int[100];
  private int length = 0;

  private void setLength(){
    int[] itens = new int[this.getLength()*2];

    for(int x = 0; x < this.getLength(); x++){
      itens[x] = this.itens[x];
    }

    this.itens = itens;
  }

  private Boolean isEmpty(){
    return this.getLength() == 0;
  }

  public int getLength(){
    return this.length;
  }

  public int front(){
    if(this.isEmpty()){
      throw new IllegalArgumentException("Fila vazia");
    }

    return this.itens[0];
  }

  public int unQueue(){
    if(this.isEmpty()){
      throw new IllegalArgumentException("Fila vazia");
    }

    int result = this.itens[0];

    for(int x = 0; x < this.getLength() - 1; x++){
      this.itens[x] = this.itens[x+1];
    }

    this.length--;
    return result;
  }
  
  public void queue(int element){
    if(this.getLength() == this.itens.length){
      this.setLength();
    }

    this.itens[this.length++] = element;
  }

  public String toString(){
    StringBuilder str = new StringBuilder();
    str.append("[");

    for(int x = 0; x < this.getLength(); x++){
      str.append(this.itens[x]);

      if(x != this.getLength()-1){
        str.append(",");
      }
    }
    
    str.append("]");

    return str.toString();
  }
}
