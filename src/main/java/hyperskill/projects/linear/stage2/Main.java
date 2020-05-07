package hyperskill.projects.linear.stage2;

import java.util.Scanner;
/*
 * Let's solve the problem with one additional variable and one additional equation. The variables would be xx and yy. The general form of this equation look like this:

\begin{cases} ax+by=c \\ dx + ey = f \end{cases}{ 
ax+by=c
dx+ey=f
​   
 

Where a, b, c, d, e, fa,b,c,d,e,f are numbers. The general algorithm is to separate the variables so the first variable would be solved on the first line and the second variable would be solved on the second line.

The main concept here is to subtract rows. You already know how to subtract numbers and subtraction of rows is not much different. Below is an example in which we subtract the first row from the second one.

\begin{cases} ax+by = c \\ dx - ax + ey - by = f - c \end{cases}{ 
ax+by=c
dx−ax+ey−by=f−c
​   
 

As you can see, we subtract ax+byax+by from the left side of the second equation and also subtract cc from the right side of an equation. Since we subtracted the equal amounts from both sides, the equation stays correct. You also can simplify this as shown below:

\begin{cases} ax+by = c \\ (d-a)x + (e-b)y = f - c \end{cases}{ 
ax+by=c
(d−a)x+(e−b)y=f−c
​   
 

But the real usefulness becomes after you realize that you can subtract only a part of an equation. Let's subtract from the second equation the first equation multiplied by d / ad/a.

\begin{cases} ax+by = c \\ (d-a * d/a)x + (e-b * d/a)y = f - c*d/a \end{cases}{ 
ax+by=c
(d−a∗d/a)x+(e−b∗d/a)y=f−c∗d/a
​   
 

Notice that d - a *d / ad−a∗d/a becomes d - dd−d and becomes 00. Therefore, we can exclude xx from the second equation.

\begin{cases} ax+by = c \\ (e-b * d/a)y = f - c*d/a \end{cases}{ 
ax+by=c
(e−b∗d/a)y=f−c∗d/a
​   
 

And there we can find the yy value. Just divide both sides by e - b * d / ae−b∗d/a.

\begin{cases} ax+by = c \\ y = \dfrac{f - c*d/a}{(e-b * d/a)} \end{cases} 
⎩
⎪
⎨
⎪
⎧
​   
  
ax+by=c
y= 
(e−b∗d/a)
f−c∗d/a
​   
 
​   
 

Now, you can find the xx value from the first equation since you know the yy value. This is a similar problem like in the previous stage.

The first line of the input contains numbers a, b, ca,b,c. The second line of the input contains numbers d, e, fd,e,f. All 6 numbers are doubles. You should output the solution - xx and yy in a single line.

You can use this link to check if your solution is right. For the approximate form without fractions, click the "Approximate form" button.

Examples

Example 1

Input:

4 5 7
3 9 9
Output:

0.85714 0.71429
Example 2

Input:

1 2 3
4 5 6
Output:

-1.0 2.0
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("add");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        double f = scanner.nextDouble();
        double y = (f - c * d / a) / (e - b * d / a);
        double x = (c - b * y) / a;
        System.out.println(x + " " + y);

    }

}
