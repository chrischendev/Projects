using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace FileRenameTool.models
{
    class FileInfo
    {
        private Int64 _id;
        private string _sourceFileName;
        private string _targetFileName;
        private string _fileExtName;

        public FileInfo()
        {
        }

        public FileInfo(long id, string sourceFileName, string targetFileName, string fileExtName)
        {
            _id = id;
            _sourceFileName = sourceFileName;
            _targetFileName = targetFileName;
            _fileExtName = fileExtName;
        }

        public long Id
        {
            get => _id;
            set => _id = value;
        }

        public string SourceFileName
        {
            get => _sourceFileName;
            set => _sourceFileName = value;
        }

        public string TargetFileName
        {
            get => _targetFileName;
            set => _targetFileName = value;
        }

        public string FileExtName
        {
            get => _fileExtName;
            set => _fileExtName = value;
        }
    }
}
