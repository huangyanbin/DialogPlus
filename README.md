# DialogPlus 
### -----------快速漂亮的Dialog
------
### 功能简介
- [x] Builder模式，一行代码创建Dialog;
- [x] 支持设置Gravity，默认Center;
- [x] 支持设置WindowAnimation,默认自带Center,bottom,top;
- [x] 支持设置Dialog宽，高
- [x] 支持设置Dialog 的Margin
- [x] 支持设置ContentView Animator 自带CircularReveal，SpringForce，RotateX,RoateY动画；
- [x] 支持设置ContentView 背景;
- [x] Demo中如何使用列表Dialog;
- [ ] 暂不支持设置DecorView。

### 使用说明
**快速使用**
```java
BaseDialog dialog = new BaseDialog.Builder(this)
.setContentView(view).create();
dialog.show();
```
**全部参数**
```java
BaseDialog dialog = new BaseDialog.Builder(this)
    .setGravity(Gravity.BOTTOM) //位置
    .setFillHeight(true) //是否充满高度
    .setFillWidth(true)//是否充满宽度
    .setAnimStyle(R.style.top_dialog_animation) //设置动画
    .setDialogStyle(R.style.base_dialog_style) //设置Dialog 样式
    .setContentViewBackground(R.drawable.dialog_white_bg)//设置contentView背景
    .setDialogAnimtor(new CircularDialogAnim())//设置属性动画
    .setContentView(view) //设置contentView
    .setMargin(50,0,0,0) //设置margin
    .create();
dialog.show();
```      
### 如何使用

> * Step 1. Add the JitPack repository to your build file
```python
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
```
> *Step 2. Add the dependency
```python
dependencies {
	        compile 'com.github.huangyanbin:DialogPlus:v1.0'
	}
```

### 后续改进方向
- [ ] 支持设置DecorView。

### 视频
![video](https://github.com/huangyanbin/DialogPlus/blob/master/dialogplus.mp4)
![](https://github.com/huangyanbin/DialogPlus/blob/master/20170920_203729.gif)


