# VanouS Motel Website

VanouS Motel là một ứng dụng web giúp hỗ trợ quản lý và đặt phòng nhà nghỉ. Hệ thống được phát triển bằng **J2EE JSP**, **MySQL**, **HTML**, **CSS**, và **JavaScript** trên nền **GlassFish Server 6.2.5** và **JDK 17**, cung cấp các chức năng thiết yếu cho cả người dùng và quản trị viên.

---

## 🎥 Demo  

🔗 Xem video demo: [https://youtu.be/J_uk7eON5sM](https://youtu.be/J_uk7eON5sM)

---

## 🛠️ Công nghệ sử dụng
- **Backend:** J2EE (Java Servlet, JSP)
- **Database:** MySQL
- **Frontend:** HTML, CSS, JavaScript
- **Máy chủ ứng dụng:** GlassFish Server 6.2.5

---

## 🌟 Chức năng chính

### **Người dùng**
1. **Đặt phòng**: 
   - Tìm kiếm phòng trống theo loại và thời gian.
   - Đặt phòng trực tiếp và nhận thông báo xác nhận.
2. **Xem đơn đặt phòng**: 
   - Theo dõi danh sách đơn đã đặt.
   - Kiểm tra trạng thái và thông tin chi tiết của từng đơn.

### **Quản trị viên**
1. **Quản lý phòng**:
   - Thêm, chỉnh sửa, hoặc xóa thông tin phòng.
   - Cập nhật tình trạng phòng (trống, đang sử dụng, bảo trì, v.v.).
2. **Quản lý loại phòng**:
   - Thêm, chỉnh sửa, hoặc xóa loại phòng.
   - Định nghĩa giá và tiện nghi từng loại.
3. **Quản lý đơn đặt phòng**:
   - Tìm kiếm, xem danh sách và trạng thái các đơn đặt phòng.
   - Xác nhận hoặc hủy các đơn đặt phòng.
4. **Thống kê**:
   - Tổng doanh thu từ đặt phòng.
   - Số lượng đơn đặt phòng đã xử lý.
   - Thống kê người dùng trên hệ thống.

---

## 💻 Cài đặt và triển khai

### Yêu cầu hệ thống
- **JDK 17**
- **GlassFish Server 6.2.5**
- **MySQL 8+**
- **IDE**: NetBeans, Eclipse hoặc IntelliJ IDEA

### Hướng dẫn cài đặt
1. Clone repository:  
   ```bash
   git clone https://github.com/pmss0168/VanousMotel
2. Import dự án vào IDE.
3. Cài đặt cơ sở dữ liệu trong file document/J2EE.sql.
4. Triển khai ứng dụng lên GlassFish Server:
    - Build file WAR từ dự án.
    - Deploy file WAR trên GlassFish Server.
5. Khởi động GlassFish Server.
6. Truy cập website tại: http://localhost:8080/VanouS-Motel.

---

## 🎯 Mục tiêu phát triển
- **Nâng cao giao diện người dùng.**
- **Tích hợp thanh toán online.**
- **Xây dựng API RESTful để hỗ trợ ứng dụng di động.**

---

## 📩 Liên hệ
Nếu bạn có bất kỳ câu hỏi hoặc góp ý nào, vui lòng liên hệ qua email: pmss0168@gmail.com.
Cảm ơn bạn đã quan tâm đến dự án của chúng tôi!
