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
            test();
        }

        /**
         * 方法测试
         */
        private void test()
        {
            //excludeSubString("中华人民共和国国歌", 7, 4);
        }

        private void initView()
        {
            //列表视图
            listViewFiles.Columns.Add("序号", 60, HorizontalAlignment.Center);
            listViewFiles.Columns.Add("源文件名", 310, HorizontalAlignment.Center);
            listViewFiles.Columns.Add("目标文件名", 310, HorizontalAlignment.Center);
            listViewFiles.Columns.Add("类型", 60, HorizontalAlignment.Center);

            //截取 单选按钮
            rbFromLeft.Select();
            nudSubRightStart.Enabled = false;
            nudSubRightLen.Enabled = false;

            //插入
            rbInsertFromLeft.Select();
            nudInsertRight.Enabled = false;

            //类型 暂时不开发这个功能，没多大意义
            tbChangeExtName.Enabled = false;

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
            if (string.IsNullOrEmpty(selectPath))
            {
                return;
            }
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
                if (string.IsNullOrEmpty(fileItem.SourceFilename) ||
                    string.IsNullOrEmpty(fileItem.TargetFilename) ||
                    string.IsNullOrEmpty(fileItem.FileExtName))
                {
                    continue;
                }

                string sourceFilePath = selectPath + fileItem.SourceFilename + fileItem.FileExtName;
                string targetFilePath = selectPath + fileItem.TargetFilename + fileItem.FileExtName;
                File.Move(sourceFilePath, targetFilePath);
            }

            MessageBox.Show("文件名修改完成");
            loadFileList(selectPath);//刷新
        }

        private void tbSeqFixStr_TextChanged(object sender, EventArgs e)
        {
            updateListViewForSeq();
        }

        /**
         * 为序列更新列表
         */
        private void updateListViewForSeq()
        {
            //MessageBox.Show(Convert.ToString(numSeqStart.Value));
            //遍历替换
            int listCount = fileItemList.Count;
            int count = Convert.ToInt32(numSeqStart.Value) + listCount - 1;
            for (int i = 0; i < listCount; i++)
            {
                FileItem fileItem = fileItemList[i];
                int idx = Convert.ToInt32(numSeqStart.Value) + i;
                fileItem.TargetFilename = tbSeqFixStr.Text + formatInt(idx, count);
            }
            //重新加载文件名列表
            loadFileItemList(fileItemList);
        }

        private void btnAddFixPre_Click(object sender, EventArgs e)
        {
            string fixPreStr = tbSeqFixStr.Text;
            if (string.IsNullOrEmpty(fixPreStr))
            {
                return;
            }
            //遍历替换
            for (int i = 0; i < fileItemList.Count; i++)
            {
                FileItem fileItem = fileItemList[i];
                int idx = Convert.ToInt32(numSeqStart.Text) + i;
                fileItem.TargetFilename = tbSeqFixStr.Text + fileItem.SourceFilename;
            }
            //重新加载文件名列表
            loadFileItemList(fileItemList);
        }

        private void btnAddFixSuffix_Click(object sender, EventArgs e)
        {
            string fixPreStr = tbSeqFixStr.Text;
            if (string.IsNullOrEmpty(fixPreStr))
            {
                return;
            }
            //遍历替换
            for (int i = 0; i < fileItemList.Count; i++)
            {
                FileItem fileItem = fileItemList[i];
                int idx = Convert.ToInt32(numSeqStart.Text) + i;
                fileItem.TargetFilename = fileItem.SourceFilename + tbSeqFixStr.Text;
            }
            //重新加载文件名列表
            loadFileItemList(fileItemList);
        }

        private void btnAddPreSeq_Click(object sender, EventArgs e)
        {
            //遍历替换
            int listCount = fileItemList.Count;
            int count = Convert.ToInt32(numSeqStart.Value) + listCount - 1;
            for (int i = 0; i < listCount; i++)
            {
                FileItem fileItem = fileItemList[i];
                int idx = Convert.ToInt32(numSeqStart.Text) + i;
                fileItem.TargetFilename = tbSeqFixStr.Text + formatInt(idx, count) + fileItem.SourceFilename;
            }
            //重新加载文件名列表
            loadFileItemList(fileItemList);
        }

        private void btnAddSuffixSeq_Click(object sender, EventArgs e)
        {
            //遍历替换
            int listCount = fileItemList.Count;
            int count = Convert.ToInt32(numSeqStart.Value) + listCount - 1;
            for (int i = 0; i < listCount; i++)
            {
                FileItem fileItem = fileItemList[i];
                int idx = Convert.ToInt32(numSeqStart.Value) + i;
                fileItem.TargetFilename = fileItem.SourceFilename + tbSeqFixStr.Text + formatInt(idx, count);
            }
            //重新加载文件名列表
            loadFileItemList(fileItemList);
        }

        private void numSeqStart_ValueChanged(object sender, EventArgs e)
        {
            updateListViewForSeq();
        }

        private void nudSubLeftStart_ValueChanged(object sender, EventArgs e)
        {
            updateListViewForRetainLeft();
        }

        private void nudSubLeftLen_ValueChanged(object sender, EventArgs e)
        {
            updateListViewForRetainLeft();
        }
        /**
         * 为保留左数截取字符串更新列表
         */
        private void updateListViewForRetainLeft()
        {
            int startPos = Convert.ToInt32(nudSubLeftStart.Value);
            int strLenth = Convert.ToInt32(nudSubLeftLen.Value);
            updateListViewForSub(startPos, strLenth, 0, 0);
        }
        /**
         * 为排除左数截取字符串更新列表
         */
        private void updateListViewForExcludeLeft()
        {
            int startPos = Convert.ToInt32(nudSubLeftStart.Value);
            int strLenth = Convert.ToInt32(nudSubLeftLen.Value);
            updateListViewForSub(startPos, strLenth, 0, 1);
        }
        private void updateListViewForSub(int startPos, int strLenth, int ori, int type)
        {
            if (startPos < 1 || strLenth < 1)
            {
                return;
            }
            //遍历替换
            for (int i = 0; i < fileItemList.Count; i++)
            {
                FileItem fileItem = fileItemList[i];
                int idx = Convert.ToInt32(numSeqStart.Text) + i;
                if (ori == 0)
                {
                    //判断索引和长度是否超出范围
                    if (strLenth > fileItem.SourceFilename.Length - startPos + 1)
                    {
                        strLenth = fileItem.SourceFilename.Length - startPos + 1;//掐掉多余的部分
                    }

                    if (type == 0)
                    {
                        //保留
                        fileItem.TargetFilename = fileItem.SourceFilename.Substring(startPos - 1, strLenth);
                    }
                    else
                    {
                        //排除
                        fileItem.TargetFilename = excludeSubString(fileItem.SourceFilename, startPos - 1, strLenth);
                        //fileItem.TargetFilename = fileItem.SourceFilename.Replace(fileItem.SourceFilename.Substring(startPos - 1, strLenth),"");
                    }

                }
                else
                {
                    //判断索引和长度是否超出范围
                    if (strLenth > startPos)
                    {
                        strLenth = startPos;//掐掉多余的部分
                    }

                    if (type == 0)
                    {
                        //保留
                        fileItem.TargetFilename = fileItem.SourceFilename.Substring(fileItem.SourceFilename.Length - startPos, strLenth);
                    }
                    else
                    {
                        //排除
                        fileItem.TargetFilename = excludeSubString(fileItem.SourceFilename, fileItem.SourceFilename.Length - startPos, strLenth);
                        //fileItem.TargetFilename = fileItem.SourceFilename.Replace(fileItem.SourceFilename.Substring(fileItem.SourceFilename.Length - startPos, strLenth),"");
                    }

                }

            }
            //重新加载文件名列表
            loadFileItemList(fileItemList);
        }

        /**
         * 从一个字符串中排除一个子字符串
         * startIndex从0开始，实际上就是字符串中字符的下标
         */
        private string excludeSubString(string str, int startIndex, int subStrLenth)
        {
            //throw new NotImplementedException();
            int strLenth = str.Length;
            //调整越界的
            if (subStrLenth > strLenth - startIndex)
            {
                subStrLenth = strLenth - startIndex;
            }
            //取得子字符串前边的部分
            string preStr = str.Substring(0, startIndex);
            //取得子字符串后边的部分
            string postStr = str.Substring(startIndex + subStrLenth);
            //拼接前后字符串
            string nStr = preStr + postStr;
            //MessageBox.Show(nStr);
            return nStr;
        }

        private void nudSubRightStart_ValueChanged(object sender, EventArgs e)
        {
            updateListViewForRetainRight();
        }

        private void nudSubRightLen_ValueChanged(object sender, EventArgs e)
        {
            updateListViewForRetainRight();
        }

        /**
         * 为保留倒数截取字符串更新列表
         */
        private void updateListViewForRetainRight()
        {
            int startPos = Convert.ToInt32(nudSubRightStart.Value);
            int strLenth = Convert.ToInt32(nudSubRightLen.Value);
            updateListViewForSub(startPos, strLenth, 1, 0);
        }
        /**
         * 为保留倒数截取字符串更新列表
         */
        private void updateListViewForExcludeRight()
        {
            int startPos = Convert.ToInt32(nudSubRightStart.Value);
            int strLenth = Convert.ToInt32(nudSubRightLen.Value);
            updateListViewForSub(startPos, strLenth, 1, 1);
        }
        /**
         * 保留截取
         */
        private void btnRetain_Click(object sender, EventArgs e)
        {
            if (rbFromLeft.Checked)
            {
                updateListViewForRetainLeft();
            }
            else
            {
                updateListViewForRetainRight();
            }
        }

        /**
         * 排除截取
         */
        private void btnExclude_Click(object sender, EventArgs e)
        {
            if (rbFromLeft.Checked)
            {
                updateListViewForExcludeLeft();
            }
            else
            {
                updateListViewForExcludeRight();
            }
        }

        private void rbFromLeft_CheckedChanged(object sender, EventArgs e)
        {
            nudSubLeftStart.Enabled = true;
            nudSubLeftLen.Enabled = true;

            nudSubRightStart.Enabled = false;
            nudSubRightLen.Enabled = false;

            updateListViewForRetainLeft();
        }

        private void rbFromRight_CheckedChanged(object sender, EventArgs e)
        {
            nudSubRightStart.Enabled = true;
            nudSubRightLen.Enabled = true;

            nudSubLeftStart.Enabled = false;
            nudSubLeftLen.Enabled = false;

            updateListViewForRetainRight();
        }

        private void tbChangeExtName_TextChanged(object sender, EventArgs e)
        {
            string extName = tbChangeExtName.Text;
            if (string.IsNullOrEmpty(extName))
            {
                return;
            }

            for (int i = 0; i < fileItemList.Count; i++)
            {
                FileItem fileItem = fileItemList[i];
                //修改类型名时，因为没有修改文件名，所以把文件名和就文件名设置为一致，避免为空
                //事实上这里需要修改FileItem，区分修改前后的类型名就好了
                fileItem.TargetFilename = fileItem.SourceFilename;
                //fileItem.FileExtName = extName.StartsWith(".") ? extName : "." + extName;
                fileItem.FileExtName = ("." + extName).Replace("..", ".");
            }
            loadFileItemList(fileItemList);
        }

        private void tbInsertStr_TextChanged(object sender, EventArgs e)
        {
            string insStr = tbInsertStr.Text;
            int indexLeft = Convert.ToInt32(nudInsertLeft.Value);
            int indexRight = Convert.ToInt32(nudInsertRight.Value);

            if (string.IsNullOrEmpty(insStr))
            {
                return;
            }

            for (int i = 0; i < fileItemList.Count; i++)
            {
                FileItem fileItem = fileItemList[i];
                if (rbInsertFromLeft.Checked)
                {
                    fileItem.TargetFilename = fileItem.SourceFilename.Insert(indexLeft, insStr);
                }
                else
                {
                    fileItem.TargetFilename = fileItem.SourceFilename.Insert(fileItem.SourceFilename.Length - indexRight, insStr);
                }
            }
            loadFileItemList(fileItemList);
        }

        /**
         * 为插入字符串更新文件名列表
         * type 0 固定字符串 1 序列
         */
        private void updateListViewForInsert(int type)
        {
            string insStr = tbInsertStr.Text;
            int indexLeft = Convert.ToInt32(nudInsertLeft.Value);
            int indexRight = Convert.ToInt32(nudInsertRight.Value);
            int indexStart = Convert.ToInt32(nudInsertStartIndex.Value);

            if (string.IsNullOrEmpty(insStr))
            {
                return;
            }

            int fileItemCount = fileItemList.Count;
            for (int i = 0; i < fileItemCount; i++)
            {
                FileItem fileItem = fileItemList[i];
                int fileNameLenth = fileItem.SourceFilename.Length;
                string seqNum = formatInt(indexStart + i, fileItemCount + indexStart);//序列
                if (rbInsertFromLeft.Checked)
                {
                    //检查一下插入点是否越界
                    if (indexLeft > fileNameLenth)
                    {
                        indexLeft = fileNameLenth;
                    }
                    if (type == 0)
                    {
                        fileItem.TargetFilename = fileItem.SourceFilename.Insert(indexLeft, insStr);
                    }
                    else
                    {
                        fileItem.TargetFilename = fileItem.SourceFilename.Insert(indexLeft, insStr + seqNum);
                    }

                }
                else
                {
                    //检查一下插入点是否越界
                    if (indexRight > fileNameLenth)
                    {
                        indexRight = fileNameLenth;
                    }
                    if (type == 0)
                    {
                        fileItem.TargetFilename = fileItem.SourceFilename.Insert(fileItem.SourceFilename.Length - indexRight, insStr);
                    }
                    else
                    {
                        fileItem.TargetFilename = fileItem.SourceFilename.Insert(fileItem.SourceFilename.Length - indexRight, insStr + seqNum);
                    }

                }
            }
            loadFileItemList(fileItemList);
        }

        private void rbInsertFromLeft_CheckedChanged(object sender, EventArgs e)
        {
            nudInsertLeft.Enabled = true;
            nudInsertRight.Enabled = false;
            updateListViewForInsert(0);
        }

        private void rbInsertFromRight_CheckedChanged(object sender, EventArgs e)
        {
            nudInsertRight.Enabled = true;
            nudInsertLeft.Enabled = false;
            updateListViewForInsert(0);
        }

        private void nudInsertLeft_ValueChanged(object sender, EventArgs e)
        {
            updateListViewForInsert(0);
        }

        private void nudInsertRight_ValueChanged(object sender, EventArgs e)
        {
            updateListViewForInsert(0);
        }

        private void btnInsertFixStr_Click(object sender, EventArgs e)
        {
            updateListViewForInsert(0);
        }

        private void btnInsertSeq_Click(object sender, EventArgs e)
        {
            updateListViewForInsert(1);
        }
    }
}
