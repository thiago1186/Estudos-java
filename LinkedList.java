class Cell<T>{
  private T element;
  private Cell<T> next;

  Cell(T element){
    this.element = element;
  }

  public T getElement(){
    return this.element;
  }
  
  public Cell<T> getNext(){
    return this.next;
  }

  public void setNext(Cell<T> cell){
    this.next = cell;
  }
}

class LinkedList<T>{
  private Cell<T> head;
  private int length = 0;

  private void addHead(T element){
    Cell<T> cell = new Cell(element);
    
    if(this.getLength() > 0){
      cell.setNext(this.head);
    }

    this.head = cell;
    this.length++;
  }

  public int getLength(){
    return this.length;
  }

  private Boolean legalPosition(int index){
    return index >=0 && index < this.getLength();
  }

  private Cell<T> getCell(int index){
    if(!this.legalPosition(index)){
      throw new IllegalArgumentException("posição inválida");
    }


    Cell<T> current = this.head;

    for(int x = 0; x < index; x++){
      current = current.getNext();
    }

    return current;
  }

  public void remove(int index){
    if(!this.legalPosition(index)){
      throw new IllegalArgumentException("posição inválida");
    }

    if(index == 0){
      this.head = this.head.getNext();
    }else{
      Cell<T> previous = this.getCell(index-1);
      previous.setNext(previous.getNext().getNext());
    }

    this.length--;
  }

  public void add(int index, T element){
    if(!this.legalPosition(index)){
      throw new IllegalArgumentException("posição inválida");
    }

    if(index == 0){
      this.addHead(element);
    }else if(index == this.getLength() - 1){
      this.add(element);
    }else{
      Cell<T> cell = new Cell<T>(element);
      Cell<T> previous = this.getCell(index-1);

      cell.setNext(previous.getNext());
      previous.setNext(cell);

      this.length++;
    }
  }
  
  public void add(T element){
    Cell<T> cell = new Cell<T>(element);

    if(this.getLength() == 0){
      this.addHead(element);
    }else{
      Cell<T> current = this.head;

      while(current.getNext() != null){
        current = current.getNext();
      }

      current.setNext(cell);
      this.length++;
    }
  }

  public String toString(){
    StringBuilder str = new StringBuilder();
    str.append("[");

    Cell<T> current = this.head;

    for(int x  = 0; x < this.getLength(); x++){
      str.append(current.getElement());

      if(x != this.getLength()-1){
        str.append(",");
      }

      current = current.getNext();
    }

    str.append("]");
    return str.toString();
  }
}
