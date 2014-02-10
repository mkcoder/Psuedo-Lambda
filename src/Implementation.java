import java.util.ArrayList;
import java.util.List;


public class Implementation {

	public static void main(String[] args) {
		List<String> source = new ArrayList<String>();
		source.add("A"); 
		source.add("B");
		source.add("CCCC"); 
		source.add("DDDDDDDDD"); 
		source.add("EEEE");
		Action a = new Action<String, String>() {
			@Override
			public boolean invoke(String item, String statement) {
				if (item.length() < 5) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		Selector<String, String> selector = new Selector<String, String>(source, "A", a);
		
		List<String> list = selector.invoke();
		System.out.println(list.toString());
		
		
		List<String> nResult = selector.changeAction(new Action<String, String>(){
			@Override
			public boolean invoke(String item, String statement) {
				// TODO Auto-generated method stub
				if (item.length() > 3) {
					return true;
				} else {
					return false;
				}
			}
			
		}).invoke();
		
		System.out.println(nResult);
	}
}


