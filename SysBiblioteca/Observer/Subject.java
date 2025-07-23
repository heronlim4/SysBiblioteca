public interface Subject {
    void adicionarObserver(Observer observer);
    void removeObserver(Observer observer);
    void notificarObserver();
}
