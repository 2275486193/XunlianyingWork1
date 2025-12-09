# PRD: 移动应用登录与个人中心实战项目

## 1. 简介 (Introduction)

| 属性 | 描述 |
| :--- | :--- |
| **项目名称** | 移动应用登录与个人中心实战项目 |
| **版本号** | V1.0 |
| **作者** | Gemini |
| **创建日期** | 2025年12月 |
| **来源** | 字节跳动 Android 训练营第二课时课后作业 |
| **目标用户** | Android 客户端开发初学者 |

---

## 2. 项目目标 (Goals)

本项目旨在通过完成核心的登录功能和个人中心页面，巩固 Android 第二课时所学的以下核心技能：

1.  熟练掌握 Android 常用 UI 组件（如 `EditText`、`ImageView`、`Button`）的使用。
2.  掌握页面跳转和数据传递（`Intent`）的实现。
3.  理解并应用客户端数据存储技术，特别是 **`SQLite` 数据库**和 **`SharedPreferences`**。
4.  实现基本的客户端交互功能（如点击事件、`Toast` 提示）。

---

## 3. 功能需求 (Functional Requirements)

### 3.1. 登录页面 (Login Page)

| 模块/功能点 | 需求描述 | 关键技术/组件 |
| :--- | :--- | :--- |
| **应用启动** | App 启动后默认进入本登录页面。 | `Activity`, `AndroidManifest.xml` (MAIN/LAUNCHER) |
| **账号输入** | 使用 `EditText` 组件供用户输入账号（用户信息）。 | `EditText` |
| **密码输入** | 使用 `EditText` 组件供用户输入密码。 | `EditText` (设置 `inputType` 为 `textPassword`) |
| **登录按钮** | 点击后触发账号密码验证逻辑，验证通过后跳转至个人中心页面。 | `Button`, 显式 `Intent` 页面跳转 |
| **账号存储要求** | 账号和密码信息必须采用 **`SQLite` 数据库**方式存储。 | `SQLiteOpenHelper`, `SQLiteDatabase` |
| **初始数据** | 首次登录时，程序必须在 `SQLite` 数据库中预埋一组账号和密码，用于登录验证。 | `SQLite` 数据库初始化 |
| **验证逻辑** | 必须具备账号和密码的验证逻辑。验证失败时，需提供提示（建议使用 `Toast`）。 | 数据库查询 (`query` 方法) |
| **第三方登录** | 实现**微信登录**和 **Apple 登录**的 UI 展示和点击事件。 | `Button` / `ImageView` |
| **第三方登录提示** | 点击微信登录和 Apple 登录按钮时，均需触发 **`Toast` 提示**。 | 点击事件监听, `Toast.makeText().show()` |

### 3.2. 个人中心页面 (User Profile Page)

| 模块/功能点 | 需求描述 | 关键技术/组件 |
| :--- | :--- | :--- |
| **头像显示** | 页面顶部需显示**圆形头像**。 | `ImageView`, 图像处理（如圆角裁剪） |
| **用户名显示** | 显示用户名称。该名称数据需使用 **`SharePreference`** 存储和获取。 | `TextView`, `SharedPreferences` |
| **签名显示** | 显示用户签名。该签名数据需使用 **`SharePreference`** 存储和获取。 | `TextView`, `SharedPreferences` |
| **信息条目点击** | 页面上的**每个信息条目**（如用户昵称、签名行、其他设置项）需具备**全条目可点**功能。 | `LinearLayout` 或 `ConstraintLayout` |
| **点击反馈** | 点击任何信息条目时，均需**弹 `Toast` 提示**。 | 点击事件监听, `Toast.makeText().show()` |

---

## 4. 非功能性需求 (Non-Functional Requirements)

| 类别 | 需求描述 |
| :--- | :--- |
| **性能** | 登录验证和页面加载应快速，用户不应感受到明显卡顿。 |
| **代码规范** | 代码结构清晰，遵循 Android 开发规范，变量和方法命名需规范。 |
| **资源使用** | UI 搭建需使用提供的 `icon.zip` 素材。 |