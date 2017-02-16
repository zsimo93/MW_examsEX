/*
 * 09th of September 2015
 */
package javaEx4;

public class PhotoBook {

	int numPhotos;
	String title;
	Photo photos[];
	String captions[];
	int ind;
	
	public PhotoBook(int numPhotos, String title) {
		this.numPhotos = numPhotos;
		this.title = title;
		photos = new Photo[numPhotos];
		captions = new String[numPhotos];
		ind = 0;
	}
	
	synchronized int add(Photo p) throws InterruptedException{
		while(ind == numPhotos) this.wait();
		photos[ind] = p;
		return ind++;
	}
	
	void setCaption(int slot, String caption){
		if(slot<numPhotos && slot >= 0)
		captions[slot] = caption;
	}
	
	void upload(SharingSvc svc){
		new Thread(new Uploader(svc, this)).run();
		
	}
	
}
