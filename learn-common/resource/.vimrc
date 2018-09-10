runtime bundle/vim-pathogen/autoload/pathogen.vim
call pathogen#infect()
Helptags
    
set nocompatible
set nu
set encoding=utf-8
set showmatch
filetype plugin indent on
set expandtab
set tabstop=4
au filetype php setl shiftwidth=4

syntax on
colorscheme molokai

"初始化所有插件
function! BundlesInit()
    let bundles = {
            \'vim-pathogen' : 'github.com/tpope/vim-pathogen.git',
            \'vim-fugitive' : 'github.com/tpope/vim-fugitive.git',
            \'nerdtree' : 'github.com/scrooloose/nerdtree.git',
            \'nerdcommenter' : 'github.com/scrooloose/nerdcommenter.git',
            \'ctrlp.vim' : 'github.com/kien/ctrlp.vim.git',
            \'tagbar' : 'github.com/majutsushi/tagbar.git',
            \'vim-taglist-plus' : 'github.com/int3/vim-taglist-plus.git',
            \'emmet-vim' : 'github.com/mattn/emmet-vim.git',
            \'syntastic' : 'github.com/scrooloose/syntastic.git',
            \'vim-colors-solarized' : 'github.com/altercation/vim-colors-solarized.git',
            \'vim-vividchalk' : 'github.com/tpope/vim-vividchalk.git',
            \'neocomplcache' : 'github.com/Shougo/neocomplcache.vim.git',
            \'molokai' : 'github.com/tomasr/molokai.git'
        \}
    let bundleDir = $HOME . '/.vim/bundle/'
    if !isdirectory(bundleDir)
        let output = mkdir(bundleDir)
    endif
    for key in keys(bundles)
        let dir = bundleDir . key
        if !isdirectory(dir)
            let cmd = 'git clone git://' . bundles[key] . ' ' . bundleDir . key
            "execute cmd
            echo 'fetching ' . key . '...'
            let output = system(cmd)
        endif
    endfor
    if exists(':Helptags')
        :Helptags
    endif
    echo 'all bundles are ready.'
endfunction
nnoremap <leader>h :call BundlesInit()<CR>

"NERDTree配置
 map <F1> :NERDTreeToggle<CR>
 map <C-F1> :NERDTreeFind<CR>
 let NERDTreeChDirMode=2  "选中root即设置为当前目录
 let NERDTreeQuitOnOpen=1 "打开文件时关闭树
 let NERDTreeShowBookmarks=1 "显示书签
 let NERDTreeMinimalUI=1 "不显示帮助面板
 let NERDTreeDirArrows=1 "目录箭头 1 显示箭头  0传统+-|号

"Ctrlp配置
 let g:ctrlp_map = '<c-p>'
 let g:ctrlp_cmd = 'CtrlP' let g:ctrlp_cmd = 'CtrlP'

"Neocomplcache配置
    let g:neocomplcache_enable_at_startup = 1

"PowerLine配置
    set laststatus=2
    set guifont=PowerlineSymbols\ for\ Powerline
    set nocompatible
    set t_Co=256
    let g:Powerline_symbols = 'fancy'

"TagList配置
map <F2> :TlistToggle<CR>


