import java.util.ArrayList;
import java.util.List;

/**
 * @author MUHAMMAD KHAN, 
 * THIS IS A SELECTOR CLASS THAT DOES ALL THE HEAVY LIFTING.
 * {@link <A HREF="http://mkscodingblog.wordpress.com">CHECK OUT MY BLOG FOR MORE INFORMATION ON MY PROJECT</a>}
 * */

// Selects string based on condition set in invoke
class Selector</*OUT => String[]*/T, /*IN => String*/U>
{
	private Func<T,U> f = new Func<T,U>() {
		
		@Override
		public final List<T> Func(List<T> source, U statement, Action action) {
			List<T> result = new ArrayList<T>();
			
			for (T item : source) {
				if (action.invoke(item, statement)) {
					result.add(item);
				}
			}
			
			return result;
		}
	};
	
	@Override
	public String toString()
	{
		return this.toString();
	}
	
	private Action a = new Action<T, U>() {
		
		@Override
		public final boolean invoke(T item, U statement) {
			if (item.equals(statement)) {
				return true;
			}
			return false;
		}
	};
	
	private U statement;
	private Action action;
	private List<T> source;
	
	public List<T> invoke()
	{
		return f.Func(source, statement, action);
	}
	
	public Selector (List<T> source, U statement, Action a)
	{
		this.statement = statement;
		if ( a == null )
		{
			this.action = this.a;
		} else {
			this.action = a;
		}
		this.source = source;
	}
	
	public Selector changeAction(Action a)
	{
		this.action = a;
		return this;
	}
}
