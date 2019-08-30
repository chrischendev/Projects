using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Windows.Forms;
using FileRenameToolVForm.models;

namespace FileRenameToolVForm
{
    public partial class FormMain : Form
    {
        private string defaultPath = "";//默认选择文件夹位置
        private string selectPath = "";//当前选择文件夹
        private List<FileItem> fileItemList = new List<FileItem>();//当前加载的文件列表

        public FormMain()
        {
            InitializeComponent();
            initView();
        }

        private void initView()
        {
            listViewFiles.Columns.Add("序号", 60, HorizontalAlignment.Center);
            listViewFiles.Columns.Add("源文件名", 310, HorizontalAlignment.Center);
            listViewFiles.Columns.Add("目标文件名", 310, HorizontalAlignment.Center);
            listViewFiles.Columns.Add("类型", 60, HorizontalAlignment.Center);


            //            ListViewItem lvi1 = new ListViewItem();
            //            lvi1.Text = "1";
            //            lvi1.SubItems.Add("名字");
            //            lvi1.SubItems.Add("名字");
            //            lvi1.SubItems.Add(".mkv");
            //            listViewFiles.Items.Add(lvi1);

        }

        private void btnQuit_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);
        }

        private void listViewFiles_SelectedIndexChanged(object sender, EventArgs e)
        {
            textBoxKeyWordSource.Text = listViewFiles.SelectedItems[0].SubItems[1].Text;
        }

        private void btnLoad_Click(object sender, EventArgs e)
        {
            //选择一个要处理的文件夹
            FolderBrowserDialog fbd = new FolderBrowserDialog();
            fbd.Description = "请选择文件夹";
            if (defaultPath != "")
            {
                fbd.SelectedPath = defaultPath;
            }
            if (fbd.ShowDialog() == DialogResult.OK)
            {
                if (string.IsNullOrEmpty(fbd.SelectedPath))
                {
                    MessageBox.Show("文件路径不能为空", "提示", MessageBoxButtons.OKCancel, MessageBoxIcon.Warning);
                }
                selectPath = fbd.SelectedPath + "\\";
                defaultPath = selectPath;
                textBoxPath.Text = selectPath;
            }
            //加载文件名列表
            loadFileList(selectPath);

        }

        private void btnRefresh_Click(object sender, EventArgs e)
        {
            loadFileList(selectPath);
        }

        /**
         * 加载文件夹下所有文件名
         */
        private void loadFileList(string selectPath)
        {
            //获取文件夹下面的所有文件
            DirectoryInfo directoryInfo = new DirectoryInfo(selectPath);
            FileInfo[] fileInfos = directoryInfo.GetFiles();

            //遍历筛选文件信息
            fileItemList.Clear();//先清空
            for (int i = 0; i < fileInfos.Length; i++)
            {
                FileInfo fileInfo = fileInfos[i];
                if ((fileInfo.Attributes & FileAttributes.Hidden) != 0)
                {
                    continue;
                }

                FileItem fileItem = new FileItem(fileInfo.Name.Replace(fileInfo.Extension, ""), null, fileInfo.Extension);
                fileItemList.Add(fileItem);
            }

            loadFileItemList(fileItemList);

        }

        /**
         * 加载fileItemList
         */
        private void loadFileItemList(List<FileItem> fileItemList)
        {
            listViewFiles.Items.Clear();//先把列表清空
            //遍历获取文件信息
            for (int i = 0; i < fileItemList.Count; i++)
            {
                FileItem fileItem = fileItemList[i];

                ListViewItem lvi1 = new ListViewItem();
                lvi1.Text = i + 1 + "";
                lvi1.SubItems.Add(fileItem.SourceFilename);
                lvi1.SubItems.Add(fileItem.TargetFilename);
                lvi1.SubItems.Add(fileItem.FileExtName);
                listViewFiles.Items.Add(lvi1);
            }
        }

        private void btnCreate_Click(object sender, EventArgs e)
        {
            int count = Convert.ToInt32(nudMockCount.Value);
            int minIndex = Convert.ToInt32(nudMockMinIndex.Value);
            int total = minIndex + count;
            string savePath = tbSavaPath.Text;
            string fixFileNameStr = tbMockFixFileNameStr.Text;
            if (count > 0 && minIndex >= 1 && !string.IsNullOrEmpty(savePath) && !string.IsNullOrEmpty(fixFileNameStr))
            {
                for (int i = minIndex; i < total; i++)
                {
                    //构建文件名 存放位置+固定名+序列名+类型名


                    string fileName = savePath + "\\" + fixFileNameStr + formatInt(i, total) + ".mkv";
                    File.CreateText(fileName);
                }
            }
            else
            {
                MessageBox.Show("请完整填写必要信息");
            }
        }

        /**
         * 格式化数字 根据总是判断需要在前面补0
         */
        private string formatInt(int i, int total)
        {
            //求得total的位数
            int num = Math.Abs(total).ToString().Length;
            string s = "";
            for (int j = 0; j < num; j++)
            {
                s = s + "0";
            }

            string s1 = "{0:" + s + "}";
            return string.Format(s1, i);
        }

        private void btnSelectSavePath_Click(object sender, EventArgs e)
        {
            FolderBrowserDialog fbd = new FolderBrowserDialog();
            fbd.Description = "请选择模拟数据存放位置";
            if (fbd.ShowDialog() == DialogResult.OK)
            {
                tbSavaPath.Text = fbd.SelectedPath;
            }
        }

        private void nudMockMinIndex_ValueChanged(object sender, EventArgs e)
        {
            int minIndex = Convert.ToInt32(nudMockMinIndex.Value);
            if (minIndex > 10)
            {
                MessageBox.Show("起始下标只能介于1和10之间");
                nudMockMinIndex.Value = 10;
            }
        }

        private void nudMockCount_ValueChanged(object sender, EventArgs e)
        {
            int count = Convert.ToInt32(nudMockCount.Value);
            if (count > 100)
            {
                MessageBox.Show("文件数只能介于1和100之间");
                nudMockCount.Value = 100;
            }
        }

        private void textBoxKeyWordSource_TextChanged(object sender, EventArgs e)
        {
            //replaceFileName();
        }

        private void textBoxKeyWordTarget_TextChanged(object sender, EventArgs e)
        {
            replaceFileName();
        }

        /**
         * 替换文件名
         */
        private void replaceFileName()
        {
            string sourceWord = textBoxKeyWordSource.Text;
            string targetWord = textBoxKeyWordTarget.Text;
            if (fileItemList == null || fileItemList.Count == 0)
            {
                MessageBox.Show("文件列表为空，无法替换");
                return;
            }
            if (string.IsNullOrEmpty(sourceWord))
            {
                MessageBox.Show("源字符串不能为空");
                return;
            }
            //遍历替换
            for (int i = 0; i < fileItemList.Count; i++)
            {
                FileItem fileItem = fileItemList[i];
                fileItem.TargetFilename = fileItem.SourceFilename.Replace(sourceWord, targetWord);
            }
            //重新加载文件名列表
            loadFileItemList(fileItemList);
        }

        /**
         * 对fileItmeList的结果执行文件名修改
         */
        private void btnExcute_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < fileItemList.Count; i++)
            {
                FileItem fileItem = fileItemList[i];
                if (string.IsNullOrEmpty(fileItem.SourceFilename)||
                    string.IsNullOrEmpty(fileItem.TargetFilename)||
                    string.IsNullOrEmpty(fileItem.FileExtName))
                {
                    continue;
                }

                string sourceFilePath = selectPath + fileItem.SourceFilename + fileItem.FileExtName;
                string targetFilePath = selectPath + fileItem.TargetFilename + fileItem.FileExtName;
                File.Move(sourceFilePath,targetFilePath);
            }

            MessageBox.Show("文件名修改完成");
            loadFileList(selectPath);//刷新
        }
    }
}
