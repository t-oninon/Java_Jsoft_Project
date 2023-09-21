package jsoft;

public interface ShareControl {
	//Chia sẻ bộ quản lý kết nối giữa các thể hiện của Basic
	public ConnectionPool getCP();
	
	//Yêu cầu đối tượng trả lại kết nối sau khi lấy xong dữ liệu
	public void releaseConnection();
}
