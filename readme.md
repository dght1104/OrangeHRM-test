First: 
mvn clean install -DskipTests            
mvn exec:java "-Dexec.mainClass=com.microsoft.playwright.CLI" "-Dexec.args=install"
mvn test "-DsuiteXmlFile=stestng.xml"


1. LOGIN MODULE
✅ Positive
Login với username + password đúng
Login bằng Enter key
Login sau khi logout
❌ Negative
Sai username
Sai password
Sai cả 2
Username đúng + password rỗng
Password đúng + username rỗng
Cả 2 rỗng
⚠️ Validation
Hiển thị message lỗi đúng
Password bị mask
Không cho submit khi thiếu field
👤 2. ADMIN – EMPLOYEE MANAGEMENT
➕ Add Employee
Thêm employee với data hợp lệ
Thêm employee không nhập required field
Thêm trùng username
Upload avatar
🔍 Search Employee
Search theo name
Search không tồn tại
Search partial name
✏️ Edit Employee
Update info thành công
Nhập data invalid
Cancel edit
❌ Delete Employee
Delete 1 employee
Delete nhiều employee
Cancel delete
🧑‍💼 3. USER MANAGEMENT (Admin)
Tạo user mới
Tạo user trùng username
Edit role user
Disable user
Delete user
📅 4. LEAVE MODULE
➕ Apply Leave
Apply leave hợp lệ
Apply leave ngày quá khứ
Apply leave không đủ balance
🔄 Approve/Reject
Approve leave
Reject leave
Cancel leave
🔍 Filter
Filter theo date
Filter theo status
⏰ 5. TIME MODULE
Add timesheet
Edit timesheet
Submit timesheet
Validate time nhập sai
📊 6. DASHBOARD
Load dashboard thành công
Widget hiển thị đúng
Click widget chuyển đúng page