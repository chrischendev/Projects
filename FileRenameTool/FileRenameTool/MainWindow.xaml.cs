using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using FileRenameTool.models;

namespace FileRenameTool
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            init();
        }

        private void init()
        {
            //            Image.Source = new BitmapImage(new Uri("../res/sh_02.jpg",UriKind.RelativeOrAbsolute));
            //            Image.Stretch = Stretch.Fill;

            ObservableCollection<FileInfo> fileInfos = new ObservableCollection<FileInfo>();
            fileInfos.Add(new FileInfo(1,"文件01.txt","",".txt"));
            fileInfos.Add(new FileInfo(2,"文件02.txt","",".txt"));

            ListView.ItemsSource = fileInfos;
        }

        private void BtnQuit_OnClick(object sender, RoutedEventArgs e)
        {
            Environment.Exit(0);
        }

        private void BtnSelectFolder_OnClick(object sender, RoutedEventArgs e)
        {
            throw new NotImplementedException();
        }

        private void BtnRefreshListView_OnClick(object sender, RoutedEventArgs e)
        {
            throw new NotImplementedException();
        }
    }
}
