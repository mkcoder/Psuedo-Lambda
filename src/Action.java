/**
 * @param no return
 * @param U is always going to be the input elements
 * */
public interface Action<T,U>
{
	boolean invoke(T item, U statement);
}