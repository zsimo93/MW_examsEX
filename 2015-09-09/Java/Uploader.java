/*
 * 09th of September 2015
 */
package javaEx4;

public class Uploader implements Runnable {

	SharingSvc svc;
	PhotoBook pb;
	
	
	public Uploader(SharingSvc svc, PhotoBook pb) {
		super();
		this.svc = svc;
		this.pb = pb;
	}


	@Override
	public void run() {
		synchronized(pb){
			svc.upload(pb.title, pb.photos, pb.captions);
			pb.photos = new Photo[pb.numPhotos];
			pb.captions = new String[pb.numPhotos];
			pb.ind = 0;
			pb.notifyAll();
		}
	}
}
