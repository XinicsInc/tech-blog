---
layout: post
title: 'WPF에서 그래픽을 이용하여 이미지 생성하기'
author: 즐회장
date: 2011-05-03 17:26
tags: [C#,GDI,Graphic,image,WPF]
---
WPF에서 GDI를 이용하여 이미지를 생성할 수 있다.
Graphics객체를 통해, 도형이나 선, 텍스트, 이미지 등을 그릴 수 있다.

[참고](http://msdn.microsoft.com/ko-kr/library/system.drawing.graphics.aspx)

아래의 예제는 파일목록들을 얻어와서 1000*1000크기의 Bitmap객체에 이미지들을 추가하여 이미지를 생성하는 코드이다.

```C#
 private void Button_Click(object sender, RoutedEventArgs e)
         { 
            Bitmap bitmap = new Bitmap(1000, 1000);
             Graphics g = Graphics.FromImage(bitmap); 

            float x = 0;
            float y = 0;
            DateTime start = System.DateTime.Now; 
            for(int i = 0; i< this.imageList.Count; i++)
             { 
                try 
                { 
                    System.Drawing.Image image = System.Drawing.Image.FromFile(this.imageList[i]);

                    g.DrawImage(image, x, y, 100, 100);
                     x += 20; 
                    y += 20; 
                    bitmap.Save(System.IO.Path.Combine(this.outputFolderPath, "test" + i.ToString() + ".png"));
                 } 
                catch (Exception) 
                { 
                    //파일 경로중 이미지가 아닌 파일의 경우 Image객체를 생성할 때, 예외가 발생한다.
                     continue; 
                } 
            } 
             
            System.Diagnostics.Debug.WriteLine("elapsed :" + System.DateTime.Now.Subtract(start).TotalSeconds.ToString());
}
```