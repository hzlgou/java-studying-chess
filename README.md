# 五子棋游戏

这是一个简单的五子棋游戏项目，包含两个版本：
- Java控制台版本（位于src目录）
- Web前端版本（HTML/CSS/JavaScript）

## 项目结构

```
java-studying-chess/
├── src/
│   └── Gobang.java          # Java控制台版本
├── index.html              # Web版本主页面
├── style.css               # Web版本样式文件
├── script.js               # Web版本逻辑文件
└── README.md               # 项目说明文档
```

## 运行方法

### Java控制台版本

#### 环境要求
- Java Development Kit (JDK) 8或更高版本
- IDE（如IntelliJ IDEA）或命令行工具

#### 运行步骤
1. **使用IDE运行**
   - 打开IntelliJ IDEA或其他Java IDE
   - 导入项目
   - 找到`src/Gobang.java`文件
   - 右键点击并选择"Run Gobang.main()"

2. **使用命令行运行**
   - 打开命令行终端
   - 进入项目根目录
   - 编译Java文件：
     ```bash
     javac src/Gobang.java
     ```
   - 运行编译后的程序：
     ```bash
     java -cp src Gobang
     ```

#### 游戏操作
- 在控制台中输入落子位置的数字（0-99）
- 例如：输入"0"表示落子在左上角，"99"表示落子在右下角
- 程序会自动判断胜负

### Web前端版本

#### 环境要求
- 任意现代浏览器（Chrome、Firefox、Edge等）

#### 运行步骤
1. **直接打开**
   - 找到项目根目录下的`index.html`文件
   - 双击打开或右键选择"在浏览器中打开"

2. **使用本地服务器（可选）**
   - 如果直接打开遇到跨域问题，可以使用本地服务器
   - 使用Python启动简单服务器：
     ```bash
     python -m http.server 8000
     ```
   - 然后在浏览器中访问：`http://localhost:8000`

#### 游戏操作
- 点击棋盘上的交叉点进行落子
- 玩家A使用黑色棋子（●），玩家B使用白色棋子（○）
- 率先在横、竖或斜方向连成5子者获胜
- 点击"重置游戏"按钮重新开始

## 游戏规则

1. 两人轮流在棋盘上落子
2. 先手玩家使用黑色棋子，后手玩家使用白色棋子
3. 率先在横向、纵向或斜向连成5个同色棋子者获胜
4. 棋盘大小为10×10

## 技术说明

- **Java版本**：使用Java SE编写，控制台界面
- **Web版本**：使用HTML5、CSS3和JavaScript ES6编写，响应式设计

## 开发工具

- IntelliJ IDEA（Java版本开发）
- 任意文本编辑器（Web版本开发）

## 作者

学习Java和Web开发的练习项目
