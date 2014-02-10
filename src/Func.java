import java.util.List;

/**
 * @param T is the output of all operations done in this class
 * @param U is the input of all params in this class
 * @return List<T> returns a List of type T
 * @category Func<TResult, TSelector>;
 * */

public interface Func<T,U>
{
	public List<T> Func(List<T> source, U statement, Action action);
}
