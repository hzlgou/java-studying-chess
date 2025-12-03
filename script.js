class GobangGame {
    constructor() {
        this.chessBoard = Array(10).fill().map(() => Array(10).fill(null));
        this.pieceA = 'black';
        this.pieceB = 'white';
        this.times = 0;
        this.gameOver = false;
        this.currentPlayer = this.pieceA;
        
        this.initGame();
    }
    
    initGame() {
        this.createChessboard();
        this.updateGameStatus();
        this.bindEvents();
    }
    
    createChessboard() {
        const chessboardElement = document.getElementById('chessboard');
        chessboardElement.innerHTML = '';
        
        for (let row = 0; row < 10; row++) {
            for (let col = 0; col < 10; col++) {
                const cell = document.createElement('div');
                cell.className = 'cell';
                cell.dataset.row = row;
                cell.dataset.col = col;
                
                cell.addEventListener('click', () => this.handleCellClick(row, col));
                
                chessboardElement.appendChild(cell);
            }
        }
    }
    
    handleCellClick(row, col) {
        if (this.gameOver) return;
        if (this.chessBoard[row][col]) return;
        
        // 落子
        this.chessBoard[row][col] = this.currentPlayer;
        this.updateCell(row, col);
        
        // 判断胜利
        if (this.checkWin(row, col)) {
            this.endGame();
            return;
        }
        
        // 切换玩家
        this.times++;
        this.currentPlayer = this.times % 2 === 0 ? this.pieceA : this.pieceB;
        this.updateGameStatus();
    }
    
    updateCell(row, col) {
        const cells = document.querySelectorAll('.cell');
        const index = row * 10 + col;
        const cell = cells[index];
        
        const piece = document.createElement('span');
        piece.className = `piece ${this.currentPlayer}`;
        piece.textContent = this.currentPlayer === this.pieceA ? '●' : '○';
        
        cell.appendChild(piece);
    }
    
    checkWin(row, col) {
        const directions = [
            { dx: 0, dy: 1 },   // 水平
            { dx: 1, dy: 0 },   // 垂直
            { dx: 1, dy: 1 },   // 对角线（右下）
            { dx: 1, dy: -1 }   // 对角线（右上）
        ];
        
        for (const dir of directions) {
            let count = 1;
            
            // 正向检查
            for (let i = 1; i < 5; i++) {
                const newRow = row + dir.dx * i;
                const newCol = col + dir.dy * i;
                
                if (this.isValidPosition(newRow, newCol) && 
                    this.chessBoard[newRow][newCol] === this.currentPlayer) {
                    count++;
                } else {
                    break;
                }
            }
            
            // 反向检查
            for (let i = 1; i < 5; i++) {
                const newRow = row - dir.dx * i;
                const newCol = col - dir.dy * i;
                
                if (this.isValidPosition(newRow, newCol) && 
                    this.chessBoard[newRow][newCol] === this.currentPlayer) {
                    count++;
                } else {
                    break;
                }
            }
            
            if (count >= 5) {
                return true;
            }
        }
        
        return false;
    }
    
    isValidPosition(row, col) {
        return row >= 0 && row < 10 && col >= 0 && col < 10;
    }
    
    updateGameStatus() {
        const statusElement = document.getElementById('status');
        const playerAElement = document.querySelector('.player-a');
        const playerBElement = document.querySelector('.player-b');
        
        // 移除所有活动状态
        playerAElement.classList.remove('active');
        playerBElement.classList.remove('active');
        
        if (this.gameOver) {
            statusElement.textContent = `${this.currentPlayer === this.pieceA ? '玩家A' : '玩家B'}获得胜利！`;
            return;
        }
        
        // 设置当前玩家活动状态
        if (this.currentPlayer === this.pieceA) {
            playerAElement.classList.add('active');
            statusElement.textContent = '轮到玩家A落子';
        } else {
            playerBElement.classList.add('active');
            statusElement.textContent = '轮到玩家B落子';
        }
    }
    
    endGame() {
        this.gameOver = true;
        this.updateGameStatus();
    }
    
    resetGame() {
        this.chessBoard = Array(10).fill().map(() => Array(10).fill(null));
        this.times = 0;
        this.gameOver = false;
        this.currentPlayer = this.pieceA;
        
        this.createChessboard();
        this.updateGameStatus();
    }
    
    bindEvents() {
        const resetBtn = document.getElementById('reset-btn');
        resetBtn.addEventListener('click', () => this.resetGame());
    }
}

// 游戏初始化
document.addEventListener('DOMContentLoaded', () => {
    new GobangGame();
});