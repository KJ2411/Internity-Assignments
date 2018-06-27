	import java.util.Comparator;
	import java.util.Map;
	import java.util.TreeMap;
public class TreeMapAndComparator {

public static void main(String[] args) 
{			
			Map<Integer,String> map = new TreeMap<>();
			
			map.put(10, "10");
			map.put(1, "1");
			map.put(5, "5");
			
			System.out.println(map);
			
			map = new TreeMap<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer x, Integer y) {
					return (x > y) ? -1 : ((x == y) ? 0 : 1);
				}
				
			});
			map.put(10, "10");
			map.put(1, "1");
			map.put(5, "5");
			System.out.println(map);

		}

	}
