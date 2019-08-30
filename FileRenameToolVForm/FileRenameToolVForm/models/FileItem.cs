using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FileRenameToolVForm.models
{
    class FileItem
    {
        private string sourceFilename;
        private string targetFilename;
        private string fileExtName;

        public FileItem()
        {
        }

        public FileItem(string sourceFilename, string targetFilename, string fileExtName)
        {
            this.sourceFilename = sourceFilename;
            this.targetFilename = targetFilename;
            this.fileExtName = fileExtName;
        }

        public string SourceFilename
        {
            get => sourceFilename;
            set => sourceFilename = value;
        }

        public string TargetFilename
        {
            get => targetFilename;
            set => targetFilename = value;
        }

        public string FileExtName
        {
            get => fileExtName;
            set => fileExtName = value;
        }
    }
}
