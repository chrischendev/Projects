namespace FileRenameToolVForm
{
    partial class FormMain
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.btnQuit = new System.Windows.Forms.Button();
            this.listViewFiles = new System.Windows.Forms.ListView();
            this.textBoxPath = new System.Windows.Forms.TextBox();
            this.btnLoad = new System.Windows.Forms.Button();
            this.btnRefresh = new System.Windows.Forms.Button();
            this.序列 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.textBoxKeyWordTarget = new System.Windows.Forms.TextBox();
            this.textBoxKeyWordSource = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.button4 = new System.Windows.Forms.Button();
            this.button3 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.button1 = new System.Windows.Forms.Button();
            this.numStart = new System.Windows.Forms.NumericUpDown();
            this.label4 = new System.Windows.Forms.Label();
            this.textBoxFixStr = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.tabPage3 = new System.Windows.Forms.TabPage();
            this.button6 = new System.Windows.Forms.Button();
            this.button5 = new System.Windows.Forms.Button();
            this.numericUpDown4 = new System.Windows.Forms.NumericUpDown();
            this.numericUpDown3 = new System.Windows.Forms.NumericUpDown();
            this.numericUpDown2 = new System.Windows.Forms.NumericUpDown();
            this.numericUpDown1 = new System.Windows.Forms.NumericUpDown();
            this.label8 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.rbFromRight = new System.Windows.Forms.RadioButton();
            this.rbFromLeft = new System.Windows.Forms.RadioButton();
            this.tabPage4 = new System.Windows.Forms.TabPage();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.label12 = new System.Windows.Forms.Label();
            this.numericUpDown6 = new System.Windows.Forms.NumericUpDown();
            this.numericUpDown5 = new System.Windows.Forms.NumericUpDown();
            this.radioButton2 = new System.Windows.Forms.RadioButton();
            this.radioButton1 = new System.Windows.Forms.RadioButton();
            this.label11 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.tabPage5 = new System.Windows.Forms.TabPage();
            this.button8 = new System.Windows.Forms.Button();
            this.button7 = new System.Windows.Forms.Button();
            this.tabPage6 = new System.Windows.Forms.TabPage();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.label13 = new System.Windows.Forms.Label();
            this.tabPage7 = new System.Windows.Forms.TabPage();
            this.btnCreate = new System.Windows.Forms.Button();
            this.btnSelectSavePath = new System.Windows.Forms.Button();
            this.tbSavaPath = new System.Windows.Forms.TextBox();
            this.label17 = new System.Windows.Forms.Label();
            this.nudMockCount = new System.Windows.Forms.NumericUpDown();
            this.label16 = new System.Windows.Forms.Label();
            this.nudMockMinIndex = new System.Windows.Forms.NumericUpDown();
            this.label15 = new System.Windows.Forms.Label();
            this.tbMockFixFileNameStr = new System.Windows.Forms.TextBox();
            this.label14 = new System.Windows.Forms.Label();
            this.btnExcute = new System.Windows.Forms.Button();
            this.序列.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numStart)).BeginInit();
            this.tabPage3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).BeginInit();
            this.tabPage4.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown6)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown5)).BeginInit();
            this.tabPage5.SuspendLayout();
            this.tabPage6.SuspendLayout();
            this.tabPage7.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudMockCount)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudMockMinIndex)).BeginInit();
            this.SuspendLayout();
            // 
            // btnQuit
            // 
            this.btnQuit.Location = new System.Drawing.Point(697, 534);
            this.btnQuit.Name = "btnQuit";
            this.btnQuit.Size = new System.Drawing.Size(75, 23);
            this.btnQuit.TabIndex = 0;
            this.btnQuit.Text = "退出";
            this.btnQuit.UseVisualStyleBackColor = true;
            this.btnQuit.Click += new System.EventHandler(this.btnQuit_Click);
            // 
            // listViewFiles
            // 
            this.listViewFiles.BackColor = System.Drawing.SystemColors.Window;
            this.listViewFiles.FullRowSelect = true;
            this.listViewFiles.GridLines = true;
            this.listViewFiles.Location = new System.Drawing.Point(12, 36);
            this.listViewFiles.Name = "listViewFiles";
            this.listViewFiles.Size = new System.Drawing.Size(760, 368);
            this.listViewFiles.TabIndex = 1;
            this.listViewFiles.UseCompatibleStateImageBehavior = false;
            this.listViewFiles.View = System.Windows.Forms.View.Details;
            this.listViewFiles.SelectedIndexChanged += new System.EventHandler(this.listViewFiles_SelectedIndexChanged);
            // 
            // textBoxPath
            // 
            this.textBoxPath.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textBoxPath.Enabled = false;
            this.textBoxPath.Location = new System.Drawing.Point(12, 8);
            this.textBoxPath.Name = "textBoxPath";
            this.textBoxPath.Size = new System.Drawing.Size(598, 21);
            this.textBoxPath.TabIndex = 2;
            // 
            // btnLoad
            // 
            this.btnLoad.Location = new System.Drawing.Point(616, 7);
            this.btnLoad.Name = "btnLoad";
            this.btnLoad.Size = new System.Drawing.Size(75, 23);
            this.btnLoad.TabIndex = 3;
            this.btnLoad.Text = "选择文件夹";
            this.btnLoad.UseVisualStyleBackColor = true;
            this.btnLoad.Click += new System.EventHandler(this.btnLoad_Click);
            // 
            // btnRefresh
            // 
            this.btnRefresh.Location = new System.Drawing.Point(697, 7);
            this.btnRefresh.Name = "btnRefresh";
            this.btnRefresh.Size = new System.Drawing.Size(75, 23);
            this.btnRefresh.TabIndex = 4;
            this.btnRefresh.Text = "刷新";
            this.btnRefresh.UseVisualStyleBackColor = true;
            this.btnRefresh.Click += new System.EventHandler(this.btnRefresh_Click);
            // 
            // 序列
            // 
            this.序列.Controls.Add(this.tabPage1);
            this.序列.Controls.Add(this.tabPage2);
            this.序列.Controls.Add(this.tabPage3);
            this.序列.Controls.Add(this.tabPage4);
            this.序列.Controls.Add(this.tabPage5);
            this.序列.Controls.Add(this.tabPage6);
            this.序列.Controls.Add(this.tabPage7);
            this.序列.Location = new System.Drawing.Point(13, 410);
            this.序列.Name = "序列";
            this.序列.SelectedIndex = 0;
            this.序列.Size = new System.Drawing.Size(678, 147);
            this.序列.TabIndex = 5;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.textBoxKeyWordTarget);
            this.tabPage1.Controls.Add(this.textBoxKeyWordSource);
            this.tabPage1.Controls.Add(this.label2);
            this.tabPage1.Controls.Add(this.label1);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(670, 121);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "替换";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // textBoxKeyWordTarget
            // 
            this.textBoxKeyWordTarget.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textBoxKeyWordTarget.Location = new System.Drawing.Point(86, 64);
            this.textBoxKeyWordTarget.Name = "textBoxKeyWordTarget";
            this.textBoxKeyWordTarget.Size = new System.Drawing.Size(571, 21);
            this.textBoxKeyWordTarget.TabIndex = 3;
            this.textBoxKeyWordTarget.TextChanged += new System.EventHandler(this.textBoxKeyWordTarget_TextChanged);
            // 
            // textBoxKeyWordSource
            // 
            this.textBoxKeyWordSource.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textBoxKeyWordSource.Location = new System.Drawing.Point(86, 24);
            this.textBoxKeyWordSource.Name = "textBoxKeyWordSource";
            this.textBoxKeyWordSource.Size = new System.Drawing.Size(571, 21);
            this.textBoxKeyWordSource.TabIndex = 2;
            this.textBoxKeyWordSource.TextChanged += new System.EventHandler(this.textBoxKeyWordSource_TextChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 68);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(65, 12);
            this.label2.TabIndex = 1;
            this.label2.Text = "目标字符串";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(24, 28);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(53, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "源字符串";
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.button4);
            this.tabPage2.Controls.Add(this.button3);
            this.tabPage2.Controls.Add(this.button2);
            this.tabPage2.Controls.Add(this.button1);
            this.tabPage2.Controls.Add(this.numStart);
            this.tabPage2.Controls.Add(this.label4);
            this.tabPage2.Controls.Add(this.textBoxFixStr);
            this.tabPage2.Controls.Add(this.label3);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(670, 121);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "序列";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // button4
            // 
            this.button4.Location = new System.Drawing.Point(577, 92);
            this.button4.Name = "button4";
            this.button4.Size = new System.Drawing.Size(87, 23);
            this.button4.TabIndex = 7;
            this.button4.Text = "添加后缀序列";
            this.button4.UseVisualStyleBackColor = true;
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(577, 63);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(87, 23);
            this.button3.TabIndex = 6;
            this.button3.Text = "添加固定后缀";
            this.button3.UseVisualStyleBackColor = true;
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(577, 34);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(87, 23);
            this.button2.TabIndex = 5;
            this.button2.Text = "添加前缀序列";
            this.button2.UseVisualStyleBackColor = true;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(577, 6);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(87, 23);
            this.button1.TabIndex = 4;
            this.button1.Text = "添加固定前缀";
            this.button1.UseVisualStyleBackColor = true;
            // 
            // numStart
            // 
            this.numStart.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.numStart.Location = new System.Drawing.Point(90, 35);
            this.numStart.Name = "numStart";
            this.numStart.Size = new System.Drawing.Size(120, 21);
            this.numStart.TabIndex = 3;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(24, 39);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(53, 12);
            this.label4.TabIndex = 2;
            this.label4.Text = "起始下标";
            // 
            // textBoxFixStr
            // 
            this.textBoxFixStr.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textBoxFixStr.Location = new System.Drawing.Point(90, 7);
            this.textBoxFixStr.Name = "textBoxFixStr";
            this.textBoxFixStr.Size = new System.Drawing.Size(465, 21);
            this.textBoxFixStr.TabIndex = 1;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 11);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(65, 12);
            this.label3.TabIndex = 0;
            this.label3.Text = "固定字符串";
            // 
            // tabPage3
            // 
            this.tabPage3.Controls.Add(this.button6);
            this.tabPage3.Controls.Add(this.button5);
            this.tabPage3.Controls.Add(this.numericUpDown4);
            this.tabPage3.Controls.Add(this.numericUpDown3);
            this.tabPage3.Controls.Add(this.numericUpDown2);
            this.tabPage3.Controls.Add(this.numericUpDown1);
            this.tabPage3.Controls.Add(this.label8);
            this.tabPage3.Controls.Add(this.label7);
            this.tabPage3.Controls.Add(this.label6);
            this.tabPage3.Controls.Add(this.label5);
            this.tabPage3.Controls.Add(this.rbFromRight);
            this.tabPage3.Controls.Add(this.rbFromLeft);
            this.tabPage3.Location = new System.Drawing.Point(4, 22);
            this.tabPage3.Name = "tabPage3";
            this.tabPage3.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage3.Size = new System.Drawing.Size(670, 121);
            this.tabPage3.TabIndex = 2;
            this.tabPage3.Text = "截取";
            this.tabPage3.UseVisualStyleBackColor = true;
            // 
            // button6
            // 
            this.button6.Location = new System.Drawing.Point(589, 92);
            this.button6.Name = "button6";
            this.button6.Size = new System.Drawing.Size(75, 23);
            this.button6.TabIndex = 11;
            this.button6.Text = "去除";
            this.button6.UseVisualStyleBackColor = true;
            // 
            // button5
            // 
            this.button5.Location = new System.Drawing.Point(508, 92);
            this.button5.Name = "button5";
            this.button5.Size = new System.Drawing.Size(75, 23);
            this.button5.TabIndex = 10;
            this.button5.Text = "截取";
            this.button5.UseVisualStyleBackColor = true;
            // 
            // numericUpDown4
            // 
            this.numericUpDown4.Location = new System.Drawing.Point(326, 53);
            this.numericUpDown4.Name = "numericUpDown4";
            this.numericUpDown4.Size = new System.Drawing.Size(120, 21);
            this.numericUpDown4.TabIndex = 9;
            // 
            // numericUpDown3
            // 
            this.numericUpDown3.Location = new System.Drawing.Point(326, 14);
            this.numericUpDown3.Name = "numericUpDown3";
            this.numericUpDown3.Size = new System.Drawing.Size(120, 21);
            this.numericUpDown3.TabIndex = 8;
            // 
            // numericUpDown2
            // 
            this.numericUpDown2.Location = new System.Drawing.Point(149, 53);
            this.numericUpDown2.Name = "numericUpDown2";
            this.numericUpDown2.Size = new System.Drawing.Size(120, 21);
            this.numericUpDown2.TabIndex = 7;
            // 
            // numericUpDown1
            // 
            this.numericUpDown1.Location = new System.Drawing.Point(149, 14);
            this.numericUpDown1.Name = "numericUpDown1";
            this.numericUpDown1.Size = new System.Drawing.Size(120, 21);
            this.numericUpDown1.TabIndex = 6;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(291, 57);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(29, 12);
            this.label8.TabIndex = 5;
            this.label8.Text = "长度";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(291, 18);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(29, 12);
            this.label7.TabIndex = 4;
            this.label7.Text = "长度";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(114, 57);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(29, 12);
            this.label6.TabIndex = 3;
            this.label6.Text = "起始";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(114, 18);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(29, 12);
            this.label5.TabIndex = 2;
            this.label5.Text = "起始";
            // 
            // rbFromRight
            // 
            this.rbFromRight.AutoSize = true;
            this.rbFromRight.Location = new System.Drawing.Point(31, 55);
            this.rbFromRight.Name = "rbFromRight";
            this.rbFromRight.Size = new System.Drawing.Size(47, 16);
            this.rbFromRight.TabIndex = 1;
            this.rbFromRight.TabStop = true;
            this.rbFromRight.Text = "倒数";
            this.rbFromRight.UseVisualStyleBackColor = true;
            // 
            // rbFromLeft
            // 
            this.rbFromLeft.AutoSize = true;
            this.rbFromLeft.Location = new System.Drawing.Point(31, 16);
            this.rbFromLeft.Name = "rbFromLeft";
            this.rbFromLeft.Size = new System.Drawing.Size(47, 16);
            this.rbFromLeft.TabIndex = 0;
            this.rbFromLeft.TabStop = true;
            this.rbFromLeft.Text = "左数";
            this.rbFromLeft.UseVisualStyleBackColor = true;
            // 
            // tabPage4
            // 
            this.tabPage4.Controls.Add(this.textBox1);
            this.tabPage4.Controls.Add(this.label12);
            this.tabPage4.Controls.Add(this.numericUpDown6);
            this.tabPage4.Controls.Add(this.numericUpDown5);
            this.tabPage4.Controls.Add(this.radioButton2);
            this.tabPage4.Controls.Add(this.radioButton1);
            this.tabPage4.Controls.Add(this.label11);
            this.tabPage4.Controls.Add(this.label10);
            this.tabPage4.Controls.Add(this.label9);
            this.tabPage4.Location = new System.Drawing.Point(4, 22);
            this.tabPage4.Name = "tabPage4";
            this.tabPage4.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage4.Size = new System.Drawing.Size(670, 121);
            this.tabPage4.TabIndex = 3;
            this.tabPage4.Text = "插入";
            this.tabPage4.UseVisualStyleBackColor = true;
            // 
            // textBox1
            // 
            this.textBox1.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textBox1.Location = new System.Drawing.Point(102, 77);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(550, 21);
            this.textBox1.TabIndex = 8;
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(23, 81);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(65, 12);
            this.label12.TabIndex = 7;
            this.label12.Text = "插入字符串";
            // 
            // numericUpDown6
            // 
            this.numericUpDown6.Location = new System.Drawing.Point(167, 42);
            this.numericUpDown6.Name = "numericUpDown6";
            this.numericUpDown6.Size = new System.Drawing.Size(120, 21);
            this.numericUpDown6.TabIndex = 6;
            // 
            // numericUpDown5
            // 
            this.numericUpDown5.Location = new System.Drawing.Point(167, 12);
            this.numericUpDown5.Name = "numericUpDown5";
            this.numericUpDown5.Size = new System.Drawing.Size(120, 21);
            this.numericUpDown5.TabIndex = 5;
            // 
            // radioButton2
            // 
            this.radioButton2.AutoSize = true;
            this.radioButton2.Location = new System.Drawing.Point(102, 44);
            this.radioButton2.Name = "radioButton2";
            this.radioButton2.Size = new System.Drawing.Size(47, 16);
            this.radioButton2.TabIndex = 4;
            this.radioButton2.TabStop = true;
            this.radioButton2.Text = "倒数";
            this.radioButton2.UseVisualStyleBackColor = true;
            // 
            // radioButton1
            // 
            this.radioButton1.AutoSize = true;
            this.radioButton1.Location = new System.Drawing.Point(102, 14);
            this.radioButton1.Name = "radioButton1";
            this.radioButton1.Size = new System.Drawing.Size(47, 16);
            this.radioButton1.TabIndex = 3;
            this.radioButton1.TabStop = true;
            this.radioButton1.Text = "左数";
            this.radioButton1.UseVisualStyleBackColor = true;
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(293, 46);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(65, 12);
            this.label11.TabIndex = 2;
            this.label11.Text = "个字符之前";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(293, 16);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(65, 12);
            this.label10.TabIndex = 1;
            this.label10.Text = "个字符之后";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(35, 16);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(53, 12);
            this.label9.TabIndex = 0;
            this.label9.Text = "插入位置";
            // 
            // tabPage5
            // 
            this.tabPage5.Controls.Add(this.button8);
            this.tabPage5.Controls.Add(this.button7);
            this.tabPage5.Location = new System.Drawing.Point(4, 22);
            this.tabPage5.Name = "tabPage5";
            this.tabPage5.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage5.Size = new System.Drawing.Size(670, 121);
            this.tabPage5.TabIndex = 4;
            this.tabPage5.Text = "表格";
            this.tabPage5.UseVisualStyleBackColor = true;
            // 
            // button8
            // 
            this.button8.Location = new System.Drawing.Point(559, 77);
            this.button8.Name = "button8";
            this.button8.Size = new System.Drawing.Size(105, 23);
            this.button8.TabIndex = 1;
            this.button8.Text = "读取电子表格";
            this.button8.UseVisualStyleBackColor = true;
            // 
            // button7
            // 
            this.button7.Location = new System.Drawing.Point(559, 21);
            this.button7.Name = "button7";
            this.button7.Size = new System.Drawing.Size(105, 23);
            this.button7.TabIndex = 0;
            this.button7.Text = "输出到电子表格";
            this.button7.UseVisualStyleBackColor = true;
            // 
            // tabPage6
            // 
            this.tabPage6.Controls.Add(this.textBox2);
            this.tabPage6.Controls.Add(this.label13);
            this.tabPage6.Location = new System.Drawing.Point(4, 22);
            this.tabPage6.Name = "tabPage6";
            this.tabPage6.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage6.Size = new System.Drawing.Size(670, 121);
            this.tabPage6.TabIndex = 5;
            this.tabPage6.Text = "类型";
            this.tabPage6.UseVisualStyleBackColor = true;
            // 
            // textBox2
            // 
            this.textBox2.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.textBox2.Location = new System.Drawing.Point(168, 51);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(161, 21);
            this.textBox2.TabIndex = 1;
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(34, 55);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(113, 12);
            this.label13.TabIndex = 0;
            this.label13.Text = "按类型名全部更改为";
            // 
            // tabPage7
            // 
            this.tabPage7.Controls.Add(this.btnCreate);
            this.tabPage7.Controls.Add(this.btnSelectSavePath);
            this.tabPage7.Controls.Add(this.tbSavaPath);
            this.tabPage7.Controls.Add(this.label17);
            this.tabPage7.Controls.Add(this.nudMockCount);
            this.tabPage7.Controls.Add(this.label16);
            this.tabPage7.Controls.Add(this.nudMockMinIndex);
            this.tabPage7.Controls.Add(this.label15);
            this.tabPage7.Controls.Add(this.tbMockFixFileNameStr);
            this.tabPage7.Controls.Add(this.label14);
            this.tabPage7.Location = new System.Drawing.Point(4, 22);
            this.tabPage7.Name = "tabPage7";
            this.tabPage7.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage7.Size = new System.Drawing.Size(670, 121);
            this.tabPage7.TabIndex = 6;
            this.tabPage7.Text = "模拟";
            this.tabPage7.UseVisualStyleBackColor = true;
            // 
            // btnCreate
            // 
            this.btnCreate.Location = new System.Drawing.Point(572, 67);
            this.btnCreate.Name = "btnCreate";
            this.btnCreate.Size = new System.Drawing.Size(88, 47);
            this.btnCreate.TabIndex = 9;
            this.btnCreate.Text = "生成模拟文件";
            this.btnCreate.UseVisualStyleBackColor = true;
            this.btnCreate.Click += new System.EventHandler(this.btnCreate_Click);
            // 
            // btnSelectSavePath
            // 
            this.btnSelectSavePath.Location = new System.Drawing.Point(458, 67);
            this.btnSelectSavePath.Name = "btnSelectSavePath";
            this.btnSelectSavePath.Size = new System.Drawing.Size(77, 23);
            this.btnSelectSavePath.TabIndex = 8;
            this.btnSelectSavePath.Text = "选择位置";
            this.btnSelectSavePath.UseVisualStyleBackColor = true;
            this.btnSelectSavePath.Click += new System.EventHandler(this.btnSelectSavePath_Click);
            // 
            // tbSavaPath
            // 
            this.tbSavaPath.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbSavaPath.Enabled = false;
            this.tbSavaPath.Location = new System.Drawing.Point(88, 68);
            this.tbSavaPath.Name = "tbSavaPath";
            this.tbSavaPath.Size = new System.Drawing.Size(363, 21);
            this.tbSavaPath.TabIndex = 7;
            // 
            // label17
            // 
            this.label17.AutoSize = true;
            this.label17.Location = new System.Drawing.Point(19, 72);
            this.label17.Name = "label17";
            this.label17.Size = new System.Drawing.Size(53, 12);
            this.label17.TabIndex = 6;
            this.label17.Text = "存放位置";
            // 
            // nudMockCount
            // 
            this.nudMockCount.Location = new System.Drawing.Point(331, 39);
            this.nudMockCount.Name = "nudMockCount";
            this.nudMockCount.Size = new System.Drawing.Size(120, 21);
            this.nudMockCount.TabIndex = 5;
            this.nudMockCount.ValueChanged += new System.EventHandler(this.nudMockCount_ValueChanged);
            // 
            // label16
            // 
            this.label16.AutoSize = true;
            this.label16.Location = new System.Drawing.Point(260, 43);
            this.label16.Name = "label16";
            this.label16.Size = new System.Drawing.Size(53, 12);
            this.label16.TabIndex = 4;
            this.label16.Text = "文件数目";
            // 
            // nudMockMinIndex
            // 
            this.nudMockMinIndex.Location = new System.Drawing.Point(88, 39);
            this.nudMockMinIndex.Maximum = new decimal(new int[] {
            10,
            0,
            0,
            0});
            this.nudMockMinIndex.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudMockMinIndex.Name = "nudMockMinIndex";
            this.nudMockMinIndex.Size = new System.Drawing.Size(120, 21);
            this.nudMockMinIndex.TabIndex = 3;
            this.nudMockMinIndex.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudMockMinIndex.ValueChanged += new System.EventHandler(this.nudMockMinIndex_ValueChanged);
            // 
            // label15
            // 
            this.label15.AutoSize = true;
            this.label15.Location = new System.Drawing.Point(19, 43);
            this.label15.Name = "label15";
            this.label15.Size = new System.Drawing.Size(53, 12);
            this.label15.TabIndex = 2;
            this.label15.Text = "序列下标";
            // 
            // tbMockFixFileNameStr
            // 
            this.tbMockFixFileNameStr.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbMockFixFileNameStr.Location = new System.Drawing.Point(88, 9);
            this.tbMockFixFileNameStr.Name = "tbMockFixFileNameStr";
            this.tbMockFixFileNameStr.Size = new System.Drawing.Size(447, 21);
            this.tbMockFixFileNameStr.TabIndex = 1;
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Location = new System.Drawing.Point(7, 13);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(65, 12);
            this.label14.TabIndex = 0;
            this.label14.Text = "固定字符串";
            // 
            // btnExcute
            // 
            this.btnExcute.Location = new System.Drawing.Point(697, 432);
            this.btnExcute.Name = "btnExcute";
            this.btnExcute.Size = new System.Drawing.Size(75, 64);
            this.btnExcute.TabIndex = 6;
            this.btnExcute.Text = "执行修改";
            this.btnExcute.UseVisualStyleBackColor = true;
            this.btnExcute.Click += new System.EventHandler(this.btnExcute_Click);
            // 
            // FormMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Window;
            this.ClientSize = new System.Drawing.Size(782, 562);
            this.ControlBox = false;
            this.Controls.Add(this.btnExcute);
            this.Controls.Add(this.序列);
            this.Controls.Add(this.btnRefresh);
            this.Controls.Add(this.btnLoad);
            this.Controls.Add(this.textBoxPath);
            this.Controls.Add(this.listViewFiles);
            this.Controls.Add(this.btnQuit);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "FormMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "文件名批量修改工具 VForm";
            this.序列.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            this.tabPage2.ResumeLayout(false);
            this.tabPage2.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numStart)).EndInit();
            this.tabPage3.ResumeLayout(false);
            this.tabPage3.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).EndInit();
            this.tabPage4.ResumeLayout(false);
            this.tabPage4.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown6)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown5)).EndInit();
            this.tabPage5.ResumeLayout(false);
            this.tabPage6.ResumeLayout(false);
            this.tabPage6.PerformLayout();
            this.tabPage7.ResumeLayout(false);
            this.tabPage7.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudMockCount)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudMockMinIndex)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnQuit;
        private System.Windows.Forms.ListView listViewFiles;
        private System.Windows.Forms.TextBox textBoxPath;
        private System.Windows.Forms.Button btnLoad;
        private System.Windows.Forms.Button btnRefresh;
        private System.Windows.Forms.TabControl 序列;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.Button btnExcute;
        private System.Windows.Forms.TabPage tabPage3;
        private System.Windows.Forms.TabPage tabPage4;
        private System.Windows.Forms.TabPage tabPage5;
        private System.Windows.Forms.TabPage tabPage6;
        private System.Windows.Forms.TabPage tabPage7;
        private System.Windows.Forms.TextBox textBoxKeyWordTarget;
        private System.Windows.Forms.TextBox textBoxKeyWordSource;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button button4;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.NumericUpDown numStart;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBoxFixStr;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button button6;
        private System.Windows.Forms.Button button5;
        private System.Windows.Forms.NumericUpDown numericUpDown4;
        private System.Windows.Forms.NumericUpDown numericUpDown3;
        private System.Windows.Forms.NumericUpDown numericUpDown2;
        private System.Windows.Forms.NumericUpDown numericUpDown1;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.RadioButton rbFromRight;
        private System.Windows.Forms.RadioButton rbFromLeft;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.NumericUpDown numericUpDown6;
        private System.Windows.Forms.NumericUpDown numericUpDown5;
        private System.Windows.Forms.RadioButton radioButton2;
        private System.Windows.Forms.RadioButton radioButton1;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Button button8;
        private System.Windows.Forms.Button button7;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.Button btnCreate;
        private System.Windows.Forms.Button btnSelectSavePath;
        private System.Windows.Forms.TextBox tbSavaPath;
        private System.Windows.Forms.Label label17;
        private System.Windows.Forms.NumericUpDown nudMockCount;
        private System.Windows.Forms.Label label16;
        private System.Windows.Forms.NumericUpDown nudMockMinIndex;
        private System.Windows.Forms.Label label15;
        private System.Windows.Forms.TextBox tbMockFixFileNameStr;
        private System.Windows.Forms.Label label14;
    }
}

