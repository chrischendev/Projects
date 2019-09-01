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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormMain));
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
            this.btnAddSuffixSeq = new System.Windows.Forms.Button();
            this.btnAddFixSuffix = new System.Windows.Forms.Button();
            this.btnAddPreSeq = new System.Windows.Forms.Button();
            this.btnAddFixPre = new System.Windows.Forms.Button();
            this.numSeqStart = new System.Windows.Forms.NumericUpDown();
            this.label4 = new System.Windows.Forms.Label();
            this.tbSeqFixStr = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.tabPage3 = new System.Windows.Forms.TabPage();
            this.btnExclude = new System.Windows.Forms.Button();
            this.btnRetain = new System.Windows.Forms.Button();
            this.nudSubRightLen = new System.Windows.Forms.NumericUpDown();
            this.nudSubLeftLen = new System.Windows.Forms.NumericUpDown();
            this.nudSubRightStart = new System.Windows.Forms.NumericUpDown();
            this.nudSubLeftStart = new System.Windows.Forms.NumericUpDown();
            this.label8 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.rbFromRight = new System.Windows.Forms.RadioButton();
            this.rbFromLeft = new System.Windows.Forms.RadioButton();
            this.tabPage4 = new System.Windows.Forms.TabPage();
            this.tbInsertStr = new System.Windows.Forms.TextBox();
            this.label12 = new System.Windows.Forms.Label();
            this.nudInsertRight = new System.Windows.Forms.NumericUpDown();
            this.nudInsertLeft = new System.Windows.Forms.NumericUpDown();
            this.rbInsertFromRight = new System.Windows.Forms.RadioButton();
            this.rbInsertFromLeft = new System.Windows.Forms.RadioButton();
            this.label11 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.tabPage5 = new System.Windows.Forms.TabPage();
            this.button8 = new System.Windows.Forms.Button();
            this.button7 = new System.Windows.Forms.Button();
            this.tabPage6 = new System.Windows.Forms.TabPage();
            this.tbChangeExtName = new System.Windows.Forms.TextBox();
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
            this.label18 = new System.Windows.Forms.Label();
            this.nudInsertStartIndex = new System.Windows.Forms.NumericUpDown();
            this.btnInsertSeq = new System.Windows.Forms.Button();
            this.btnInsertFixStr = new System.Windows.Forms.Button();
            this.序列.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.numSeqStart)).BeginInit();
            this.tabPage3.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudSubRightLen)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudSubLeftLen)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudSubRightStart)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudSubLeftStart)).BeginInit();
            this.tabPage4.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudInsertRight)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudInsertLeft)).BeginInit();
            this.tabPage5.SuspendLayout();
            this.tabPage6.SuspendLayout();
            this.tabPage7.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudMockCount)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudMockMinIndex)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudInsertStartIndex)).BeginInit();
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
            this.tabPage2.Controls.Add(this.btnAddSuffixSeq);
            this.tabPage2.Controls.Add(this.btnAddFixSuffix);
            this.tabPage2.Controls.Add(this.btnAddPreSeq);
            this.tabPage2.Controls.Add(this.btnAddFixPre);
            this.tabPage2.Controls.Add(this.numSeqStart);
            this.tabPage2.Controls.Add(this.label4);
            this.tabPage2.Controls.Add(this.tbSeqFixStr);
            this.tabPage2.Controls.Add(this.label3);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(670, 121);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "序列";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // btnAddSuffixSeq
            // 
            this.btnAddSuffixSeq.Location = new System.Drawing.Point(577, 92);
            this.btnAddSuffixSeq.Name = "btnAddSuffixSeq";
            this.btnAddSuffixSeq.Size = new System.Drawing.Size(87, 23);
            this.btnAddSuffixSeq.TabIndex = 7;
            this.btnAddSuffixSeq.Text = "添加后缀序列";
            this.btnAddSuffixSeq.UseVisualStyleBackColor = true;
            this.btnAddSuffixSeq.Click += new System.EventHandler(this.btnAddSuffixSeq_Click);
            // 
            // btnAddFixSuffix
            // 
            this.btnAddFixSuffix.Location = new System.Drawing.Point(577, 63);
            this.btnAddFixSuffix.Name = "btnAddFixSuffix";
            this.btnAddFixSuffix.Size = new System.Drawing.Size(87, 23);
            this.btnAddFixSuffix.TabIndex = 6;
            this.btnAddFixSuffix.Text = "添加固定后缀";
            this.btnAddFixSuffix.UseVisualStyleBackColor = true;
            this.btnAddFixSuffix.Click += new System.EventHandler(this.btnAddFixSuffix_Click);
            // 
            // btnAddPreSeq
            // 
            this.btnAddPreSeq.Location = new System.Drawing.Point(577, 34);
            this.btnAddPreSeq.Name = "btnAddPreSeq";
            this.btnAddPreSeq.Size = new System.Drawing.Size(87, 23);
            this.btnAddPreSeq.TabIndex = 5;
            this.btnAddPreSeq.Text = "添加前缀序列";
            this.btnAddPreSeq.UseVisualStyleBackColor = true;
            this.btnAddPreSeq.Click += new System.EventHandler(this.btnAddPreSeq_Click);
            // 
            // btnAddFixPre
            // 
            this.btnAddFixPre.Location = new System.Drawing.Point(577, 6);
            this.btnAddFixPre.Name = "btnAddFixPre";
            this.btnAddFixPre.Size = new System.Drawing.Size(87, 23);
            this.btnAddFixPre.TabIndex = 4;
            this.btnAddFixPre.Text = "添加固定前缀";
            this.btnAddFixPre.UseVisualStyleBackColor = true;
            this.btnAddFixPre.Click += new System.EventHandler(this.btnAddFixPre_Click);
            // 
            // numSeqStart
            // 
            this.numSeqStart.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.numSeqStart.Location = new System.Drawing.Point(90, 35);
            this.numSeqStart.Maximum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.numSeqStart.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.numSeqStart.Name = "numSeqStart";
            this.numSeqStart.Size = new System.Drawing.Size(120, 21);
            this.numSeqStart.TabIndex = 3;
            this.numSeqStart.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.numSeqStart.ValueChanged += new System.EventHandler(this.numSeqStart_ValueChanged);
            this.numSeqStart.Click += new System.EventHandler(this.numSeqStart_ValueChanged);
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
            // tbSeqFixStr
            // 
            this.tbSeqFixStr.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbSeqFixStr.Location = new System.Drawing.Point(90, 7);
            this.tbSeqFixStr.Name = "tbSeqFixStr";
            this.tbSeqFixStr.Size = new System.Drawing.Size(465, 21);
            this.tbSeqFixStr.TabIndex = 1;
            this.tbSeqFixStr.TextChanged += new System.EventHandler(this.tbSeqFixStr_TextChanged);
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
            this.tabPage3.Controls.Add(this.btnExclude);
            this.tabPage3.Controls.Add(this.btnRetain);
            this.tabPage3.Controls.Add(this.nudSubRightLen);
            this.tabPage3.Controls.Add(this.nudSubLeftLen);
            this.tabPage3.Controls.Add(this.nudSubRightStart);
            this.tabPage3.Controls.Add(this.nudSubLeftStart);
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
            // btnExclude
            // 
            this.btnExclude.Location = new System.Drawing.Point(589, 92);
            this.btnExclude.Name = "btnExclude";
            this.btnExclude.Size = new System.Drawing.Size(75, 23);
            this.btnExclude.TabIndex = 11;
            this.btnExclude.Text = "去除";
            this.btnExclude.UseVisualStyleBackColor = true;
            this.btnExclude.Click += new System.EventHandler(this.btnExclude_Click);
            // 
            // btnRetain
            // 
            this.btnRetain.Location = new System.Drawing.Point(508, 92);
            this.btnRetain.Name = "btnRetain";
            this.btnRetain.Size = new System.Drawing.Size(75, 23);
            this.btnRetain.TabIndex = 10;
            this.btnRetain.Text = "截取";
            this.btnRetain.UseVisualStyleBackColor = true;
            this.btnRetain.Click += new System.EventHandler(this.btnRetain_Click);
            // 
            // nudSubRightLen
            // 
            this.nudSubRightLen.Location = new System.Drawing.Point(326, 53);
            this.nudSubRightLen.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudSubRightLen.Name = "nudSubRightLen";
            this.nudSubRightLen.Size = new System.Drawing.Size(120, 21);
            this.nudSubRightLen.TabIndex = 9;
            this.nudSubRightLen.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudSubRightLen.ValueChanged += new System.EventHandler(this.nudSubRightLen_ValueChanged);
            // 
            // nudSubLeftLen
            // 
            this.nudSubLeftLen.Location = new System.Drawing.Point(326, 14);
            this.nudSubLeftLen.Maximum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.nudSubLeftLen.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudSubLeftLen.Name = "nudSubLeftLen";
            this.nudSubLeftLen.Size = new System.Drawing.Size(120, 21);
            this.nudSubLeftLen.TabIndex = 8;
            this.nudSubLeftLen.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudSubLeftLen.ValueChanged += new System.EventHandler(this.nudSubLeftLen_ValueChanged);
            // 
            // nudSubRightStart
            // 
            this.nudSubRightStart.Location = new System.Drawing.Point(149, 53);
            this.nudSubRightStart.Maximum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.nudSubRightStart.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudSubRightStart.Name = "nudSubRightStart";
            this.nudSubRightStart.Size = new System.Drawing.Size(120, 21);
            this.nudSubRightStart.TabIndex = 7;
            this.nudSubRightStart.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudSubRightStart.ValueChanged += new System.EventHandler(this.nudSubRightStart_ValueChanged);
            // 
            // nudSubLeftStart
            // 
            this.nudSubLeftStart.Location = new System.Drawing.Point(149, 14);
            this.nudSubLeftStart.Maximum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.nudSubLeftStart.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudSubLeftStart.Name = "nudSubLeftStart";
            this.nudSubLeftStart.Size = new System.Drawing.Size(120, 21);
            this.nudSubLeftStart.TabIndex = 6;
            this.nudSubLeftStart.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudSubLeftStart.ValueChanged += new System.EventHandler(this.nudSubLeftStart_ValueChanged);
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
            this.rbFromRight.Text = "倒数";
            this.rbFromRight.UseVisualStyleBackColor = true;
            this.rbFromRight.CheckedChanged += new System.EventHandler(this.rbFromRight_CheckedChanged);
            // 
            // rbFromLeft
            // 
            this.rbFromLeft.AutoSize = true;
            this.rbFromLeft.Checked = true;
            this.rbFromLeft.Location = new System.Drawing.Point(31, 16);
            this.rbFromLeft.Name = "rbFromLeft";
            this.rbFromLeft.Size = new System.Drawing.Size(47, 16);
            this.rbFromLeft.TabIndex = 0;
            this.rbFromLeft.TabStop = true;
            this.rbFromLeft.Text = "左数";
            this.rbFromLeft.UseVisualStyleBackColor = true;
            this.rbFromLeft.CheckedChanged += new System.EventHandler(this.rbFromLeft_CheckedChanged);
            // 
            // tabPage4
            // 
            this.tabPage4.Controls.Add(this.btnInsertFixStr);
            this.tabPage4.Controls.Add(this.btnInsertSeq);
            this.tabPage4.Controls.Add(this.nudInsertStartIndex);
            this.tabPage4.Controls.Add(this.label18);
            this.tabPage4.Controls.Add(this.tbInsertStr);
            this.tabPage4.Controls.Add(this.label12);
            this.tabPage4.Controls.Add(this.nudInsertRight);
            this.tabPage4.Controls.Add(this.nudInsertLeft);
            this.tabPage4.Controls.Add(this.rbInsertFromRight);
            this.tabPage4.Controls.Add(this.rbInsertFromLeft);
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
            // tbInsertStr
            // 
            this.tbInsertStr.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbInsertStr.Location = new System.Drawing.Point(102, 77);
            this.tbInsertStr.Name = "tbInsertStr";
            this.tbInsertStr.Size = new System.Drawing.Size(467, 21);
            this.tbInsertStr.TabIndex = 8;
            this.tbInsertStr.TextChanged += new System.EventHandler(this.tbInsertStr_TextChanged);
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
            // nudInsertRight
            // 
            this.nudInsertRight.Location = new System.Drawing.Point(167, 42);
            this.nudInsertRight.Maximum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.nudInsertRight.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudInsertRight.Name = "nudInsertRight";
            this.nudInsertRight.Size = new System.Drawing.Size(120, 21);
            this.nudInsertRight.TabIndex = 6;
            this.nudInsertRight.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudInsertRight.ValueChanged += new System.EventHandler(this.nudInsertRight_ValueChanged);
            // 
            // nudInsertLeft
            // 
            this.nudInsertLeft.Location = new System.Drawing.Point(167, 12);
            this.nudInsertLeft.Maximum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.nudInsertLeft.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudInsertLeft.Name = "nudInsertLeft";
            this.nudInsertLeft.Size = new System.Drawing.Size(120, 21);
            this.nudInsertLeft.TabIndex = 5;
            this.nudInsertLeft.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudInsertLeft.ValueChanged += new System.EventHandler(this.nudInsertLeft_ValueChanged);
            // 
            // rbInsertFromRight
            // 
            this.rbInsertFromRight.AutoSize = true;
            this.rbInsertFromRight.Location = new System.Drawing.Point(102, 44);
            this.rbInsertFromRight.Name = "rbInsertFromRight";
            this.rbInsertFromRight.Size = new System.Drawing.Size(47, 16);
            this.rbInsertFromRight.TabIndex = 4;
            this.rbInsertFromRight.TabStop = true;
            this.rbInsertFromRight.Text = "倒数";
            this.rbInsertFromRight.UseVisualStyleBackColor = true;
            this.rbInsertFromRight.CheckedChanged += new System.EventHandler(this.rbInsertFromRight_CheckedChanged);
            // 
            // rbInsertFromLeft
            // 
            this.rbInsertFromLeft.AutoSize = true;
            this.rbInsertFromLeft.Location = new System.Drawing.Point(102, 14);
            this.rbInsertFromLeft.Name = "rbInsertFromLeft";
            this.rbInsertFromLeft.Size = new System.Drawing.Size(47, 16);
            this.rbInsertFromLeft.TabIndex = 3;
            this.rbInsertFromLeft.TabStop = true;
            this.rbInsertFromLeft.Text = "左数";
            this.rbInsertFromLeft.UseVisualStyleBackColor = true;
            this.rbInsertFromLeft.CheckedChanged += new System.EventHandler(this.rbInsertFromLeft_CheckedChanged);
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
            this.tabPage6.Controls.Add(this.tbChangeExtName);
            this.tabPage6.Controls.Add(this.label13);
            this.tabPage6.Location = new System.Drawing.Point(4, 22);
            this.tabPage6.Name = "tabPage6";
            this.tabPage6.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage6.Size = new System.Drawing.Size(670, 121);
            this.tabPage6.TabIndex = 5;
            this.tabPage6.Text = "类型";
            this.tabPage6.UseVisualStyleBackColor = true;
            // 
            // tbChangeExtName
            // 
            this.tbChangeExtName.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbChangeExtName.Location = new System.Drawing.Point(168, 51);
            this.tbChangeExtName.Name = "tbChangeExtName";
            this.tbChangeExtName.Size = new System.Drawing.Size(161, 21);
            this.tbChangeExtName.TabIndex = 1;
            this.tbChangeExtName.TextChanged += new System.EventHandler(this.tbChangeExtName_TextChanged);
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
            // label18
            // 
            this.label18.AutoSize = true;
            this.label18.Location = new System.Drawing.Point(400, 46);
            this.label18.Name = "label18";
            this.label18.Size = new System.Drawing.Size(53, 12);
            this.label18.TabIndex = 9;
            this.label18.Text = "开始下标";
            // 
            // nudInsertStartIndex
            // 
            this.nudInsertStartIndex.Location = new System.Drawing.Point(459, 42);
            this.nudInsertStartIndex.Maximum = new decimal(new int[] {
            1000,
            0,
            0,
            0});
            this.nudInsertStartIndex.Minimum = new decimal(new int[] {
            1,
            0,
            0,
            0});
            this.nudInsertStartIndex.Name = "nudInsertStartIndex";
            this.nudInsertStartIndex.Size = new System.Drawing.Size(110, 21);
            this.nudInsertStartIndex.TabIndex = 10;
            this.nudInsertStartIndex.Value = new decimal(new int[] {
            1,
            0,
            0,
            0});
            // 
            // btnInsertSeq
            // 
            this.btnInsertSeq.Location = new System.Drawing.Point(589, 41);
            this.btnInsertSeq.Name = "btnInsertSeq";
            this.btnInsertSeq.Size = new System.Drawing.Size(75, 23);
            this.btnInsertSeq.TabIndex = 11;
            this.btnInsertSeq.Text = "插入序列";
            this.btnInsertSeq.UseVisualStyleBackColor = true;
            this.btnInsertSeq.Click += new System.EventHandler(this.btnInsertSeq_Click);
            // 
            // btnInsertFixStr
            // 
            this.btnInsertFixStr.Location = new System.Drawing.Point(589, 76);
            this.btnInsertFixStr.Name = "btnInsertFixStr";
            this.btnInsertFixStr.Size = new System.Drawing.Size(75, 23);
            this.btnInsertFixStr.TabIndex = 12;
            this.btnInsertFixStr.Text = "插入";
            this.btnInsertFixStr.UseVisualStyleBackColor = true;
            this.btnInsertFixStr.Click += new System.EventHandler(this.btnInsertFixStr_Click);
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
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
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
            ((System.ComponentModel.ISupportInitialize)(this.numSeqStart)).EndInit();
            this.tabPage3.ResumeLayout(false);
            this.tabPage3.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudSubRightLen)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudSubLeftLen)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudSubRightStart)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudSubLeftStart)).EndInit();
            this.tabPage4.ResumeLayout(false);
            this.tabPage4.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudInsertRight)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudInsertLeft)).EndInit();
            this.tabPage5.ResumeLayout(false);
            this.tabPage6.ResumeLayout(false);
            this.tabPage6.PerformLayout();
            this.tabPage7.ResumeLayout(false);
            this.tabPage7.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.nudMockCount)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudMockMinIndex)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nudInsertStartIndex)).EndInit();
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
        private System.Windows.Forms.Button btnAddSuffixSeq;
        private System.Windows.Forms.Button btnAddFixSuffix;
        private System.Windows.Forms.Button btnAddPreSeq;
        private System.Windows.Forms.Button btnAddFixPre;
        private System.Windows.Forms.NumericUpDown numSeqStart;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox tbSeqFixStr;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnExclude;
        private System.Windows.Forms.Button btnRetain;
        private System.Windows.Forms.NumericUpDown nudSubRightLen;
        private System.Windows.Forms.NumericUpDown nudSubLeftLen;
        private System.Windows.Forms.NumericUpDown nudSubRightStart;
        private System.Windows.Forms.NumericUpDown nudSubLeftStart;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.RadioButton rbFromRight;
        private System.Windows.Forms.RadioButton rbFromLeft;
        private System.Windows.Forms.TextBox tbInsertStr;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.NumericUpDown nudInsertRight;
        private System.Windows.Forms.NumericUpDown nudInsertLeft;
        private System.Windows.Forms.RadioButton rbInsertFromRight;
        private System.Windows.Forms.RadioButton rbInsertFromLeft;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Button button8;
        private System.Windows.Forms.Button button7;
        private System.Windows.Forms.TextBox tbChangeExtName;
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
        private System.Windows.Forms.Button btnInsertFixStr;
        private System.Windows.Forms.Button btnInsertSeq;
        private System.Windows.Forms.NumericUpDown nudInsertStartIndex;
        private System.Windows.Forms.Label label18;
    }
}

