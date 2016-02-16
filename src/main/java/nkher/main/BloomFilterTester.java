package nkher.main;

import nkher.datastructures.bloomfilter.BloomFilter;

public class BloomFilterTester {

	public static void main(String[] args) {
				
		BloomFilter<String> bloomFilter = new BloomFilter<>(1000, 0.1);
		
		System.out.println("Size is : " + bloomFilter.size() + ", Capacity is : " + bloomFilter.capacity());
		
		bloomFilter.add("https://github.com");
		bloomFilter.add("https://twitter.com");
		bloomFilter.add("https://www.facebook.com");
		bloomFilter.add("https://www.quora.com");
		bloomFilter.add("https://www.linkedin.com");
		bloomFilter.add("https://www.yelp.com");
		
		System.out.println("Size after insertions : " + bloomFilter.size());
		
		System.out.println(bloomFilter.contains("https://github.com"));
		System.out.println(bloomFilter.contains("https://www.quora.com"));
		System.out.println(bloomFilter.contains("https://www.google.com"));
		System.out.println(bloomFilter.contains("https://www.linkedin.com"));
	}

}
