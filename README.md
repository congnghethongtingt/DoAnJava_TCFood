# ĐỒ ÁN JAVA SWING - QUẢN LÝ QUÁN ĂN NHANH TC FOOD 🥘

- Đồ án này còn khá nhiều lỗi, thiếu nhiều chức năng nghiệp vụ mình đang cải thiện và phát triển lên cho đồ án cơ sở của mình, mình sẽ cập nhật và chia sẻ sau khi hoàn thành.
- Vì đây là đồ án sinh viên, mình sẽ không chịu trách nhiệm các vấn đề khác về phần mềm, các vấn đề lấy source của mình nộp cho đồ án của các bạn. Mình tạo bài này mang tính chất cho các bạn xem tham khảo và với tinh thần mong nhận được những góp ý cần cải thiện về phần mềm ở những trang của mình ở ⬇️🤡

  * <a href="https://www.facebook.com/congnghethongtingt"><img align="left" width="30" height="30" 
src="https://github.com/giathanh2512/giathanh2512/blob/main/Photos/facebook_36px.png?raw=true">Facebook</a>

  * <a href="https://www.youtube.com/channel/UCa52u55QtvEZuhcv1JFidFA"><img align="left" width="30" height="30" src="https://github.com/giathanh2512/giathanh2512/blob/main/Photos/YouTube_36px.png?raw=true">Youtube</a>
 
# 🎬 VIDEO DEMO

  - <a href="https://www.youtube.com/watch?v=qi8mlyk14ds"><img align="left" width="30" height="30" src="https://github.com/giathanh2512/giathanh2512/blob/main/Photos/YouTube_36px.png?raw=true">Youtube</a>
 
    * Chỉ nên xem tham khảo và xây dựng thành đồ án của riêng mình chứ không nên lấy cả bài để nộp đâu nhe 😄
    *  ❣️ Hy vọng có thể giúp ích được cho sản phẩm của các bạn. Chúc các bạn học tốt 💻
## ↗️ Kết quả đạt được
-	Giao diện đăng nhập.
-	Thêm/giảm món ăn trong hoá đơn đặt món.
-	Thêm, sửa, xóa thực đơn món ăn.
-	Thêm, sửa, xoá danh sách bàn.
-	Thêm, sửa, xoá nhân viên.
-	Thanh toán hóa đơn. 
-	Tìm kiếm thông tin nhân viên trong nhân viên.
-	Tìm kiếm món ăn trong thực đơn.
-	Thống kê được doanh thu.
-	Nhân viên không thể dùng trang quản lý nhân viên

## 👿 Lỗi => cần cải thiện
- Tốc độ của các jframe load chậm khi chuyển jframe => Cải thiện tốc độ load - xây dựng các trang quản lý thành panel và quản lý trên cùng 1 jframe? hoặc cách nào đó 😅
-	Lưu và lấy ảnh bằng đường dẫn máy nên khi phần mềm chạy ở máy khác sẽ bị lỗi cần cập nhật lại đường dẫn ảnh => Lưu và lấy ảnh từ project
-	Chưa có quản lý các loại món ăn => Tạo thêm trang quản lý danh mục loại món ăn
-	Chưa có giảm giá hoặc tính thuế VAT vào hóa đơn => Tạo giảm giá theo mỗi món ăn hoặc mã giảm theo tổng số tiền hóa đơn - tạo checkbox Vat khi tick vào sẽ tính thuế VAT
-	Chưa xem lại được hóa đơn đã thanh toán => Cần tạo 1 trang quản lý các hóa đơn đã thanh toán, có thể chỉnh sửa số lượng hoặc xóa món trong hóa đơn
-	Chưa in được hóa đơn => Cần tạo report để xuất hóa đơn thanh toán
-	Chưa phân quyền được cho tài khoản => Cần phân quyền cho các tài khoản Admin và Staff - 1 nhân viên chỉ có thể tạo và chỉnh sửa hóa đơn với tên của mình, không được tùy chỉnh chọn tên của người khác
-	Chưa có quản lý tài khoản đăng nhập, thay đổi mật khẩu => Tạo thêm trang quản lý tài khoản và thay đổi mật khẩu
-	Chưa quản lý được doanh thu theo lựa chọn như theo món ăn, theo nhân viên, theo thời gian => Tạo commbobox, jtextfiel lấy dữ liệu và button tra cứu, còn về thời gian có thể sử dụng JDateChooser khi click vào sẽ xuất ra các hóa đơn theo dữ liệu được chọn
-	....
